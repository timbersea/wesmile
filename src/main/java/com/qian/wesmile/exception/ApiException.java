package com.qian.wesmile.exception;

public class ApiException extends RuntimeException {
    private int errcode;
    private String errmsg;
    private String hints;
    private String response;

    public ApiException(int errcode, String errmsg, String hints, String response) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.hints = hints;
        this.response = response;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
