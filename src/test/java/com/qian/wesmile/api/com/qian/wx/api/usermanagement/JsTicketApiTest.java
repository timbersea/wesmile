package com.qian.wesmile.api.com.qian.wx.api.usermanagement;

import com.qian.wesmile.api.APITestBase;
import com.qian.wesmile.api.js.JsTicketApi;
import com.qian.wesmile.model.result.JsTicketResult;
import org.junit.Test;

public class JsTicketApiTest extends APITestBase<JsTicketApi> {
    @Test
    public void test() {
        JsTicketResult wx_card = api.getticket("wx_card");
        result = wx_card;
    }
}
