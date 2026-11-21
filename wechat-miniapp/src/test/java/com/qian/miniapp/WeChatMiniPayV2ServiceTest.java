package com.qian.miniapp;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class WeChatMiniPayV2ServiceTest extends TestBase {

    static WeChatMiniPayV2Service service;

    @BeforeAll
    public static void createService() throws IOException {
        service = weChat.createService(WeChatMiniPayV2Service.class);
    }

    @Test
    void unifiedOrder() {
        WeChatMiniPayV2Service.WeChatMiniPayUnifiedOrderReq weChatMiniPayUnifiedOrderReq = new WeChatMiniPayV2Service.WeChatMiniPayUnifiedOrderReq();
        weChatMiniPayUnifiedOrderReq.setAppid(appid);
        weChatMiniPayUnifiedOrderReq.setMchId(appid);

        service.unifiedOrder(weChatMiniPayUnifiedOrderReq);
    }

    @Test
    void orderQuery() {
    }

    @Test
    void closeOrder() {
    }

    @Test
    void refund() {
    }

    @Test
    void refundQuery() {
    }
}