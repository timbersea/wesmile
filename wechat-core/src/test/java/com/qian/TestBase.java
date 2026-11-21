package com.qian;

import com.qian.core.WeChat;

import java.io.IOException;

public class TestBase {
    public static WeChat weChat;

    public static void setUp() throws IOException {
        weChat = new WeChat();
        weChat.init("wx58eb449027e55fd6", "759fd46efc0b4f9195cc5353e9ec5409");
    }
}
