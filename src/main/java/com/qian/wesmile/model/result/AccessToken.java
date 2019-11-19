package com.qian.wesmile.model.result;

public class AccessToken {

    private String access_token = "27_9NykbKgI33D2" +
            "-VErRNMi_eArNql_ctnFaRaYAJA_VjxC3bZIIJZYjonz10emxuYnfpI1M_D9N1InjsP_EIGy8_fWGq0312_UpUKOex6ejEuunZNoXih6hNVaBwOGKLRx9JqARxPKIRaIqsoCOEKiACARHN";
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
