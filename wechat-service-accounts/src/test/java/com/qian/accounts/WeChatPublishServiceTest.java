package com.qian.accounts;

import com.qian.core.WechatApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class WeChatPublishServiceTest extends TestBase {

    static WeChatPublishService service;

    @BeforeAll
    public static void createService() throws IOException {
        service = weChat.createService(WeChatPublishService.class);
    }

    @Test
    void submitPublish() {
        WeChatPublishService.WeChatPublishSubmitReq weChatPublishSubmitReq =
                new WeChatPublishService.WeChatPublishSubmitReq();
        weChatPublishSubmitReq.setMediaId("123");
        Assertions.assertThrows(WechatApiException.class, () -> {
            service.submitPublish(weChatPublishSubmitReq);
        });
    }

    @Test
    void getPublish() {
        WeChatPublishService.WeChatPublishGetReq weChatPublishGetReq = new WeChatPublishService.WeChatPublishGetReq();
        weChatPublishGetReq.setPublishId("123");
        Assertions.assertThrows(WechatApiException.class, () -> {
            WeChatPublishService.WeChatPublishGetResp publish = service.getPublish(weChatPublishGetReq);
        });

    }

    @Test
    void deletePublish() {
        WeChatPublishService.WeChatPublishDeleteReq weChatPublishDeleteReq =
                new WeChatPublishService.WeChatPublishDeleteReq();
        weChatPublishDeleteReq.setArticleId("1234");
        Assertions.assertThrows(WechatApiException.class, () -> {
            service.deletePublish(weChatPublishDeleteReq);
        });
    }

    @Test
    void getArticle() {
        WeChatPublishService.WeChatPublishArticleReq weChatPublishArticleReq =
                new WeChatPublishService.WeChatPublishArticleReq();
        weChatPublishArticleReq.setArticleId("1234");
        Assertions.assertThrows(WechatApiException.class, () -> {
            service.getArticle(weChatPublishArticleReq);
        });
    }

    @Test
    void batchGetPublish() {
        WeChatPublishService.WeChatPublishBatchReq weChatPublishBatchReq =
                new WeChatPublishService.WeChatPublishBatchReq();
        weChatPublishBatchReq.setCount(10);
        weChatPublishBatchReq.setOffset(1);
        weChatPublishBatchReq.setNoContent(1);
        service.batchGetPublish(weChatPublishBatchReq);
    }
}