package com.qian.wesmile.request;

/**
 * @author wuhuaiqian
 */
public abstract class AbstractHttpRequester {

    /**
     * send http request body data to the url by your self
     * you may use other http client
     *
     * @param url
     * @param body
     * @return the response String result
     */
    public abstract String sendHttpRequest(String url, String body);
}
