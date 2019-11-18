package com.qian.wesmile.request;

/**
 * @author wuhuaiqian
 */
public interface HttpRequester {

    String doRequest(String url, String jsonBody);

    String getAccessToken();

}
