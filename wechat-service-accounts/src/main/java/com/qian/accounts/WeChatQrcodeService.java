package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 公众号服务平台 - 二维码接口
 * 官方文档地址：[https://developers.weixin.qq.com/doc/service/api/qrcode/](https://developers.weixin.qq
 * .com/doc/service/api/qrcode/)
 *
 * @author auto-gen
 */
public interface WeChatQrcodeService {
    /**
     * 创建二维码ticket
     * <p>生成二维码ticket，凭借ticket可换取二维码图片。</p>
     *
     * @param req 创建二维码请求
     * @return 二维码ticket响应
     */
    @POST("cgi-bin/qrcode/create")
    WeChatQrcodeCreateResp createQrcode(@Body WeChatQrcodeCreateReq req);

    /**
     * 通过ticket换取二维码
     * <p>根据ticket下载二维码图片。</p>
     *
     * @param ticket 获取二维码ticket
     * @return 图片二进制流
     */
    @GET("cgi-bin/showqrcode")
    okhttp3.ResponseBody showQrcode(@Query("ticket") String ticket);

    class WeChatQrcodeCreateReq {
        @JsonProperty("expire_seconds")
        private Integer expireSeconds;
        @JsonProperty("action_name")
        private String actionName;
        @JsonProperty("action_info")
        private WeChatQrcodeActionInfo actionInfo;

        public Integer getExpireSeconds() {
            return expireSeconds;
        }

        public void setExpireSeconds(Integer expireSeconds) {
            this.expireSeconds = expireSeconds;
        }

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public WeChatQrcodeActionInfo getActionInfo() {
            return actionInfo;
        }

        public void setActionInfo(WeChatQrcodeActionInfo actionInfo) {
            this.actionInfo = actionInfo;
        }
    }

    class WeChatQrcodeActionInfo {
        private WeChatQrcodeScene scene;

        public WeChatQrcodeScene getScene() {
            return scene;
        }

        public void setScene(WeChatQrcodeScene scene) {
            this.scene = scene;
        }
    }

    class WeChatQrcodeScene {
        @JsonProperty("scene_id")
        private Integer sceneId;
        @JsonProperty("scene_str")
        private String sceneStr;

        public Integer getSceneId() {
            return sceneId;
        }

        public void setSceneId(Integer sceneId) {
            this.sceneId = sceneId;
        }

        public String getSceneStr() {
            return sceneStr;
        }

        public void setSceneStr(String sceneStr) {
            this.sceneStr = sceneStr;
        }
    }

    class WeChatQrcodeCreateResp {
        private String ticket;
        @JsonProperty("expire_seconds")
        private Integer expireSeconds;
        @JsonProperty("url")
        private String url;

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public Integer getExpireSeconds() {
            return expireSeconds;
        }

        public void setExpireSeconds(Integer expireSeconds) {
            this.expireSeconds = expireSeconds;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
