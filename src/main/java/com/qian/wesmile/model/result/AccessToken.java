package com.qian.wesmile.model.result;

public class AccessToken {

    private String access_token =
            "27_i31dnfUlDByngbjzQYk8bg7oqAHDANgcSmjJLoj7ok_sXvrJA0mryAeSe26WzMWlMAhKGqneFWnO6KuPxylR1xCCnXg4aNmODmIiYRvX3qHOPI8Bs0t-IgmL3kQhi5gNte6k5yiTGZNtU_AnVCBhAJAZGF";
    private long createTimestamp=System.currentTimeMillis();

    private Integer expires_in;

    public AccessToken(String accessToken, long createTimestamp) {
        this.access_token = accessToken;
        this.createTimestamp = createTimestamp;
    }

    public AccessToken() {
    }

    public boolean isExpire(){
        return false;
        // return System.currentTimeMillis()-createTimestamp>7200;
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
