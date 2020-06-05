package com.qian.wesmile.model.result;

public class AccessToken {

    private String access_token;
    private long createTimestamp = System.currentTimeMillis();
    private Integer expires_in;

    public AccessToken() {
    }

    public boolean isExpire() {
        return access_token == null || System.currentTimeMillis() - createTimestamp > 7000 * 1000;
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

    @Override
    public String toString() {
        return "AccessToken{" +
                "access_token='" + access_token + '\'' +
                ", createTimestamp=" + createTimestamp +
                ", expires_in=" + expires_in +
                '}';
    }
}
