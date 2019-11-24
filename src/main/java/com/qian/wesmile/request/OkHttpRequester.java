package com.qian.wesmile.request;

import com.alibaba.fastjson.JSON;
import com.qian.wesmile.WeSmile;
import com.qian.wesmile.exception.ApiException;
import com.qian.wesmile.model.result.APIResult;
import com.qian.wesmile.model.result.AccessToken;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

}
