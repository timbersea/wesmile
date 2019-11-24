package com.qian.wesmile.request;

import com.qian.wesmile.model.result.AccessToken;

/**
 * @author wuhuaiqian
 */
public interface HttpRequester {

    String doRequest(String url, String jsonBody);

    String sendHttpRequest(String url, String body);
}
