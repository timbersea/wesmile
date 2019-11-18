package com.qian.wesmile.api.config;

public class MyAPIConfig implements Config {
    @Override
    public String getAppid() {
        return "your appid";
    }

    @Override
    public String getAppsecret() {
        return "your secret";
    }

    @Override
    public String getDomain() {
        return "api.weixin.qq.com";
    }
}
