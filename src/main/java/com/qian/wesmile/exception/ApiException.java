package com.qian.wesmile.exception;

public class ApiException extends RuntimeException {
    private String response;

    public ApiException() {
    }

    public ApiException(String response) {
        super(response);
        this.response = response;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "response='" + response + '\'' +
                '}';
    }
}
