package com.qian.wesmile.spi;

public interface AccessTokenManager {
    /**
     * if can't get an access token ,you must return an "null" string,if access token invalid,framework will
     * handle it well
     *
     * @return access token
     */
    String getAccessToken();

    /**
     * save it to anywhere you want
     *
     * @param accessToken
     */
    void saveAccessToken(String accessToken);
}
