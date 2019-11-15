package com.qian.wx.model.result;

import com.alibaba.fastjson.annotation.JSONField;

public class AccessToken {
    @JSONField(name = "access_token")
    private String accessToken;
    private long createTimestamp=System.currentTimeMillis();

    private Integer expires_in;

    public AccessToken(String accessToken, long createTimestamp) {
        this.accessToken = accessToken;
        this.createTimestamp = createTimestamp;
    }

    public boolean isExpire(){
        return System.currentTimeMillis()-createTimestamp>7200;
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
}
