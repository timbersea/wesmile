package com.qian.wesmile.api.config;

public class MyAPIConfig implements Config {
    @Override
    public String getAppid() {
        return "wx4cd768add2b9d6ab";
    }

    @Override
    public String getAppsecret() {
        return "d405b278eb3b99da1cb020a2c52d3935";
    }

    @Override
    public String getDomain() {
        return "api.weixin.qq.com";
    }
}
