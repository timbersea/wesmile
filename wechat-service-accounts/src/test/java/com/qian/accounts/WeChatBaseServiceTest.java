package com.qian.accounts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class WeChatBaseServiceTest extends TestBase {

    static WeChatBaseService service;

    @BeforeAll
    public static void createService() throws IOException {
        service = weChat.createService(WeChatBaseService.class);
    }

    @Test
    void getApiDomainIp() {
        WeChatBaseService.WeChatGetApiDomainIpResp apiDomainIp = service.getApiDomainIp();
    }

    @Test
    void getCallbackIp() {
        WeChatBaseService.WeChatGetCallbackIpResp callbackIp = service.getCallbackIp();
    }

    @Test
    void callbackCheck() {
        WeChatBaseService.WeChatCallbackCheckReq weChatCallbackCheckReq =
                new WeChatBaseService.WeChatCallbackCheckReq();
        weChatCallbackCheckReq.setAction("all");
        weChatCallbackCheckReq.setCheckOperator("DEFAULT");
        WeChatBaseService.WeChatCallbackCheckResp weChatCallbackCheckResp =
                service.callbackCheck(weChatCallbackCheckReq);
    }

    @Test
    void getStableToken() {
        WeChatBaseService.WeChatStableTokenReq weChatStableTokenReq = new WeChatBaseService.WeChatStableTokenReq();
        weChatStableTokenReq.setAppid(appid);
        weChatStableTokenReq.setSecret(appsecret);
        weChatStableTokenReq.setGrantType("client_credential");
        WeChatBaseService.WeChatStableTokenResp stableToken = service.getStableToken(weChatStableTokenReq);
    }
}