package com.qian.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.ByteString;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;

public class WeChatResponseConverterFactory extends retrofit2.Converter.Factory {

    private final ObjectMapper preCheckMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final retrofit2.Converter.Factory delegateFactory;

    private WeChatResponseConverterFactory(retrofit2.Converter.Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    public static WeChatResponseConverterFactory wrap(retrofit2.Converter.Factory delegateFactory) {
        return new WeChatResponseConverterFactory(delegateFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Converter<ResponseBody, ?> delegateConverter = delegateFactory.responseBodyConverter(type, annotations,
                retrofit);
        if (delegateConverter == null) {
            return null;
        }
        return new WxBodyConverter((Converter<ResponseBody, Object>) delegateConverter);
    }

    // ========== 重点补上：代理 requestBodyConverter（@Body序列化用） ==========
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations,
                                                          Retrofit retrofit) {
        return delegateFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    // 可选：stringConverter 也代理，防止 @Query 等参数转换异常
    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return delegateFactory.stringConverter(type, annotations, retrofit);
    }

    private class WxBodyConverter implements Converter<ResponseBody, Object> {
        private final Converter<ResponseBody, Object> delegate;

        WxBodyConverter(Converter<ResponseBody, Object> delegate) {
            this.delegate = delegate;
        }

        @SuppressWarnings("unchecked")
        @Override
        public Object convert(ResponseBody value) throws IOException {
            String respStr = value.string();
            MediaType mediaType = value.contentType();
            ByteString byteString = ByteString.encodeUtf8(respStr);
            ResponseBody cacheBody = ResponseBody.create(byteString, mediaType);

            Map<String, Object> root;
            try {
                root = preCheckMapper.readValue(respStr, Map.class);
            } catch (IOException e) {
                throw new WechatApiException(null, "JSON预解析失败:" + e.getMessage(), null, null, respStr);
            }
            Object errcodeObj = root.get("errcode");
            if (errcodeObj != null) {
                int errcode = ((Number) errcodeObj).intValue();
                String errmsg = root.getOrDefault("errmsg", "").toString();
                if (errcode != 0) {
                    throw new WechatApiException(errcode, errmsg, null, null, respStr);
                }
            }
            return delegate.convert(cacheBody);
        }
    }
}
