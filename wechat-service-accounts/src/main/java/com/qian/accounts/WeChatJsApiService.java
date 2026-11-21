package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 公众号服务平台 - JS-SDK ticket 接口
 * 文档地址：https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html
 *
 * @author auto-gen
 */
public interface WeChatJsApiService {

    /**
     * 获取jsapi_ticket
     */
    @GET("cgi-bin/ticket/getticket")
    WeChatJsApiTicketResp getJsApiTicket(
                                         @Query("type") String type);

    class WeChatJsApiTicketResp {
        @JsonProperty("errcode")
        private Integer errCode;
        @JsonProperty("errmsg")
        private String errMsg;
        @JsonProperty("ticket")
        private String ticket;
        @JsonProperty("expires_in")
        private Integer expiresIn;

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
        public String getTicket() {
            return ticket;
        }
        public void setTicket(String ticket) {
            this.ticket = ticket;
        }
        public Integer getExpiresIn() {
            return expiresIn;
        }
        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }
    }
}
