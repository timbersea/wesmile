package com.qian.core;

public class WechatApiException extends RuntimeException {
    private Integer errcode;
    private String errmsg;
    private String url;
    private String requestBody;
    private String responseBody;

    public WechatApiException(Integer errcode, String errmsg, String url, String requestBody, String responseBody) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.url = url;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "WechatApiException{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", url='" + url + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
