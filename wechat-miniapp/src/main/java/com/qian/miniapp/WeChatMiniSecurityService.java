package com.qian.miniapp;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 小程序内容安全接口
 * 文档地址：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/sec-check/security.msgSecCheck.html
 *
 * @author auto-gen
 */
public interface WeChatMiniSecurityService {

    /**
     * 文本内容安全检测
     */
    @POST("wxa/msg_sec_check")
    WeChatMiniMsgSecCheckResp msgSecCheck(
            @Body WeChatMiniMsgSecCheckReq req);

    /**
     * 图片内容安全检测
     */
    @POST("wxa/img_sec_check")
    WeChatMiniImgSecCheckResp imgSecCheck(
            @Body WeChatMiniImgSecCheckReq req);

    class WeChatMiniSecBaseResp {
        @JsonProperty("errcode")
        private Integer errCode;
        @JsonProperty("errmsg")
        private String errMsg;

        public Integer getErrCode() {
            return errCode;
        }

        public void setErrCode(Integer errCode) {
            this.errCode = errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }
    }

    class WeChatMiniMsgSecCheckReq {
        @JsonProperty("content")
        private String content;
        @JsonProperty("version")
        private Integer version;
        @JsonProperty("scene")
        private Integer scene;
        @JsonProperty("openid")
        private String openid;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public Integer getScene() {
            return scene;
        }

        public void setScene(Integer scene) {
            this.scene = scene;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }

    class WeChatMiniMsgSecCheckResp extends WeChatMiniSecBaseResp {
        @JsonProperty("result")
        private WeChatMiniSecResult result;

        public WeChatMiniSecResult getResult() {
            return result;
        }

        public void setResult(WeChatMiniSecResult result) {
            this.result = result;
        }
    }

    class WeChatMiniSecResult {
        @JsonProperty("suggest")
        private String suggest;
        @JsonProperty("label")
        private Integer label;
        @JsonProperty("detail")
        private Object detail;

        public String getSuggest() {
            return suggest;
        }

        public void setSuggest(String suggest) {
            this.suggest = suggest;
        }

        public Integer getLabel() {
            return label;
        }

        public void setLabel(Integer label) {
            this.label = label;
        }

        public Object getDetail() {
            return detail;
        }

        public void setDetail(Object detail) {
            this.detail = detail;
        }
    }

    class WeChatMiniImgSecCheckReq {
        @JsonProperty("media")
        private String media;

        public String getMedia() {
            return media;
        }

        public void setMedia(String media) {
            this.media = media;
        }
    }

    class WeChatMiniImgSecCheckResp extends WeChatMiniSecBaseResp {
    }
}

