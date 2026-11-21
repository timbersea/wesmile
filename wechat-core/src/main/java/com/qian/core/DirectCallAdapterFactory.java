package com.qian.core;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class DirectCallAdapterFactory extends CallAdapter.Factory {

    public static DirectCallAdapterFactory create() {
        return new DirectCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new CallAdapter<Object, Object>() {
            @Override
            public Type responseType() {
                return returnType;
            }

            @Override
            public Object adapt(Call<Object> call) {
                Request okRequest = call.request();
                String url = okRequest.url().toString();
                String reqBodyStr = readRequestBody(okRequest);

                Response<Object> response;
                try {
                    response = call.execute();
                    if(!response.isSuccessful()){
                        throw new WechatApiException(response.code(),"Http response is not successful",url,reqBodyStr
                                ,null);
                    }
                } catch (IOException e) {
                    throw new WechatApiException(null, "call execute IO异常: " + e.getMessage(), url, reqBodyStr, null);
                }
                // interceptor 已经做完 errcode、http 状态校验，直接返回解析好的实体
                return response.body();
            }

            private String readRequestBody(Request request) {
                if (request.body() == null) {
                    return null;
                }
                try {
                    okio.Buffer buffer = new okio.Buffer();
                    request.newBuilder().build().body().writeTo(buffer);
                    return buffer.readUtf8();
                } catch (IOException e) {
                    return "[read req body error]";
                }
            }
        };
    }
}
