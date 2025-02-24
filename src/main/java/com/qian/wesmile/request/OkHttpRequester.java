package com.qian.wesmile.request;

import okhttp3.*;

import java.io.IOException;

/**
 * @author wuhuaiqian
 */
public class OkHttpRequester extends AbstractHttpRequester {
    protected static OkHttpClient client = new OkHttpClient();
    protected static Request.Builder builder = new Request.Builder();


    @Override
    public String sendHttpRequest(String url, String body) {
        builder.url(url);
        if (body != null && !body.isEmpty()) {
            RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), body);
            builder.post(requestBody);
        }
        Request build = builder.build();
        try (Response response = client.newCall(build).execute()) {
            return new String(response.body().bytes());
        } catch (IOException e) {
            throw new RuntimeException(e.toString(), e.getCause());
        }
    }

}
