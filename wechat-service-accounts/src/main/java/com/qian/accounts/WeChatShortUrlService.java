package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 公众号服务平台 - 长短链接转换接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Account_Management/URL_Shortener.html
 *
 * @author auto-gen
 */
public interface WeChatShortUrlService {

    /**
     * 长链接转短链接
     */
    @POST("cgi-bin/shorturl")
    WeChatShortUrlResp shortUrl(@Body WeChatShortUrlReq req);

    class WeChatBaseResp {
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

    class WeChatShortUrlReq {
        @JsonProperty("action")
        private String action;
        @JsonProperty("long_url")
        private String longUrl;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getLongUrl() {
            return longUrl;
        }

        public void setLongUrl(String longUrl) {
            this.longUrl = longUrl;
        }
    }

    class WeChatShortUrlResp extends WeChatBaseResp {
        @JsonProperty("short_url")
        private String shortUrl;

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }
    }
}

