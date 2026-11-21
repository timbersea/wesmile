package com.qian.accounts;

import com.qian.core.WeChat;

public class TestBase {
    public static final String appid = "wx58eb449027e55fd6";
    public static final String appsecret = "759fd46efc0b4f9195cc5353e9ec5409";
    public static WeChat weChat;

    static {
        weChat = new WeChat();
        weChat.init(appid, appsecret);
    }
}
