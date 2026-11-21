package com.qian.interceptor;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qian.core.WeChatTokenResp;
import com.qian.core.WeChatTokenStorage;
import com.qian.core.WechatApiException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WeChatTokenRetryInterceptor implements Interceptor {

    private static final int MAX_RETRY = 3;
    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final String appid;
    private final String secret;
    private final WeChatTokenStorage tokenStorage;
    private final okhttp3.OkHttpClient tokenHttpClient;
    private final Lock refreshLock = new ReentrantLock();

    public WeChatTokenRetryInterceptor(String appid, String secret, WeChatTokenStorage tokenStorage) {
        this.appid = appid;
        this.secret = secret;
        this.tokenStorage = tokenStorage;
        this.tokenHttpClient = new okhttp3.OkHttpClient();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        String path = originRequest.url().encodedPath();
        if (path.contains("/cgi-bin/token")) {
            return chain.proceed(originRequest);
        }

        int retryCount = 0;
        Request currentRequest = buildRequestWithToken(originRequest, getValidToken());

        while (retryCount < MAX_RETRY) {
            Response response = chain.proceed(currentRequest);
            ResponseBody originBody = response.body();
            if (originBody == null) {
                return response;
            }

            BufferedSource source = originBody.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.getBuffer();
            String respBodyStr = buffer.clone().readUtf8();
            Map<String, Object> respMap;
            try {
                respMap = mapper.readValue(respBodyStr, Map.class);
            } catch (Exception e) {
                return rebuildResponse(response, respBodyStr);
            }

            Object errcodeObj = respMap.get("errcode");
            if (errcodeObj == null) {
                return rebuildResponse(response, respBodyStr);
            }

            int errcode = ((Number) errcodeObj).intValue();
            if (errcode == 40001) {
                retryCount++;
                tokenStorage.clearToken();
                String newToken = getValidToken();
                currentRequest = buildRequestWithToken(originRequest, newToken);
                response.close();
                continue;
            }

            if (errcode != 0) {
                String errmsg = respMap.getOrDefault("errmsg", "").toString();
                throw new WechatApiException(errcode, errmsg,
                        currentRequest.url().toString(),
                        readRequestBody(currentRequest),
                        respBodyStr);
            }

            return rebuildResponse(response, respBodyStr);
        }

        Response finalResp = chain.proceed(currentRequest);
        ResponseBody finalBody = finalResp.body();
        if (finalBody == null) {
            return finalResp;
        }
        BufferedSource source = finalBody.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.getBuffer();
        String respBodyStr = buffer.clone().readUtf8();
        return rebuildResponse(finalResp, respBodyStr);
    }

    private String getValidToken() throws IOException {
        String cached = tokenStorage.getToken();
        if (cached != null) {
            return cached;
        }

        refreshLock.lock();
        try {
            String checkAgain = tokenStorage.getToken();
            if (checkAgain != null) {
                return checkAgain;
            }
            String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
                    + "&appid=" + appid
                    + "&secret=" + secret;
            Request tokenReq = new Request.Builder()
                    .url(tokenUrl)
                    .get()
                    .build();
            try (Response resp = tokenHttpClient.newCall(tokenReq).execute()) {
                if (!resp.isSuccessful() || resp.body() == null) {
                    return null;
                }
                String bodyStr = resp.body().string();
                WeChatTokenResp tokenResp = mapper.readValue(bodyStr, WeChatTokenResp.class);
                String newToken = tokenResp.getAccess_token();
                tokenStorage.saveToken(newToken, tokenResp.getExpires_in());
                return newToken;
            }
        } finally {
            refreshLock.unlock();
        }
    }

    private Request buildRequestWithToken(Request originRequest, String token) {
        if (token == null || token.trim().isEmpty()) {
            return originRequest;
        }
        HttpUrl newUrl = originRequest.url()
                .newBuilder()
                .setQueryParameter("access_token", token)
                .build();
        return originRequest.newBuilder()
                .url(newUrl)
                .build();
    }

    @SuppressWarnings("unchecked")
    private Response rebuildResponse(Response rawResp, String bodyStr) {
        okhttp3.MediaType mediaType = rawResp.body() != null ? rawResp.body().contentType() : null;
        ByteString byteString = ByteString.encodeUtf8(bodyStr);
        ResponseBody newBody = ResponseBody.create(byteString, mediaType);
        return rawResp.newBuilder()
                .body(newBody)
                .build();
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
}
