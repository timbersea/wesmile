package com.qian.wesmile.model.result;

public class AccessToken {

    private String access_token;
    private long createTimestamp = System.currentTimeMillis();

    private Integer expires_in;

    public AccessToken(String accessToken, long createTimestamp) {
        this.access_token = accessToken;
        this.createTimestamp = createTimestamp;
    }

    public AccessToken() {
    }

    public boolean isExpire() {
        return access_token == null || System.currentTimeMillis() - createTimestamp > 7200 * 1000;
    }

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String accessToken) {
        this.access_token = accessToken;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
