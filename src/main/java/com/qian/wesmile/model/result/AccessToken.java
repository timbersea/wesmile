package com.qian.wesmile.model.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonIgnore
    private long createTimestamp = System.currentTimeMillis();
    @JsonProperty("expires_in")
    private Integer expiresIn;

    public AccessToken() {
    }

    public boolean isExpire() {
        return accessToken == null || System.currentTimeMillis() - createTimestamp > 7000 * 1000;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
                "access_token='" + accessToken + '\'' +
                ", createTimestamp=" + createTimestamp +
                ", expires_in=" + expiresIn +
                '}';
    }
}
