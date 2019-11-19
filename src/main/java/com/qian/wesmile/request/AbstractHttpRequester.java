package com.qian.wesmile.request;

import com.qian.wesmile.model.result.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author wuhuaiqian
 */
public abstract class AbstractHttpRequester implements HttpRequester {
    private static OkHttpClient client = new OkHttpClient();
    private static Request.Builder builder = new Request.Builder();
    String accesstoken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public AccessToken getAccessToken() {
        return null;
    }
}
