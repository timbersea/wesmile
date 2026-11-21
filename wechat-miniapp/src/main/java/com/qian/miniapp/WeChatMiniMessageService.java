package com.qian.miniapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 小程序订阅消息接口
 * 文档地址：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.send
 * .html
 *
 * @author auto-gen
 */
public interface WeChatMiniMessageService {

    /**
     * 发送订阅消息
     */
    @POST("cgi-bin/message/subscribe/send")
    WeChatMiniSubscribeMsgResp sendSubscribeMsg(
            @Body WeChatMiniSubscribeMsgReq req);

    class WeChatMiniMsgBaseResp {
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

    class WeChatMiniSubscribeMsgReq {
        @JsonProperty("touser")
        private String toUser;
        @JsonProperty("template_id")
        private String templateId;
        @JsonProperty("page")
        private String page;
        @JsonProperty("data")
        private Object data;
        @JsonProperty("miniprogram_state")
        private String miniProgramState;
        @JsonProperty("lang")
        private String lang;

        public String getToUser() {
            return toUser;
        }

        public void setToUser(String toUser) {
            this.toUser = toUser;
        }

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String getMiniProgramState() {
            return miniProgramState;
        }

        public void setMiniProgramState(String miniProgramState) {
            this.miniProgramState = miniProgramState;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }

    class WeChatMiniSubscribeMsgResp extends WeChatMiniMsgBaseResp {
    }
}
