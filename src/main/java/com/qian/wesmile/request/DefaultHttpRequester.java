package com.qian.wesmile.request;

import com.alibaba.fastjson.JSON;
import com.qian.wesmile.WeSmile;
import com.qian.wesmile.model.result.APIResult;
import com.qian.wesmile.model.result.AccessToken;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wuhuaiqian
 */
public class DefaultHttpRequester implements HttpRequester {
    protected static AccessToken accessToken = new AccessToken();
    private static String GET_ACCESS_TOKEN_URL_PATTERN = "%s/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";


    private static final Logger log = LoggerFactory.getLogger(DefaultHttpRequester.class);


    protected static OkHttpClient client = new OkHttpClient();
    protected static Request.Builder builder = new Request.Builder();

    @Override
    public String doRequest(String url, String body) {
        String urlWithAccessToken = String.format(url, getAccessToken().getAccessToken());
        builder.url(urlWithAccessToken);
        if (body != null && !body.isEmpty()) {
            RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), body);
            builder.post(requestBody);
        }
        log.debug("url {} \r\n body{}", urlWithAccessToken, body);
        try (Response response = client.newCall(builder.build()).execute()) {

            String result = new String(response.body().bytes());
            APIResult apiResult = JSON.parseObject(result, APIResult.class);
            if (apiResult.success()) {
                return result;
            }
            else if (apiResult.getErrcode() == 42001) {
                onAccessTokenExpire();
                doRequest(url, body);
            }
            else {
                throw new RuntimeException("can't get correct result from " + result);
            }

            log.debug("response {}", result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void onAccessTokenExpire() {
        DefaultHttpRequester.accessToken = null;
    }

    @Override
    public AccessToken getAccessToken() {
        if (DefaultHttpRequester.accessToken == null || DefaultHttpRequester.accessToken.isExpire()) {
            String url = String.format(GET_ACCESS_TOKEN_URL_PATTERN, WeSmile.domain, WeSmile.appid, WeSmile.appSecret);
            builder.url(url);
            try (Response response = client.newCall(builder.build()).execute()) {

                String result = new String(response.body().bytes());
                log.debug("response {}", result);
                AccessToken accessToken = JSON.parseObject(result, AccessToken.class);
                DefaultHttpRequester.accessToken = accessToken;
                return accessToken;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        else {
            return DefaultHttpRequester.accessToken;
        }

    }

}
