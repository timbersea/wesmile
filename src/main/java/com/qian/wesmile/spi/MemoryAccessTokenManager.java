package com.qian.wesmile.spi;

public class MemoryAccessTokenManager implements AccessTokenManager {
    private String ACCESS_TOKEN;

    @Override
    public String getAccessToken() {
        return ACCESS_TOKEN;
    }

    @Override
    public void saveAccessToken(String accessToken) {
        ACCESS_TOKEN = accessToken;
    }
}
