package com.qian.wesmile.request;

/**
 * @author wuhuaiqian
 */
public abstract class AbstractHttpRequester {
    /**
     * send http request body data to url
     *
     * @param url
     * @param jsonBody
     * @return
     */
    public abstract String doRequest(String url, String jsonBody);
}
