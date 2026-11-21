package com.qian.miniapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 小程序基础接口
 * 文档地址：https://developers.weixin.qq.com/miniprogram/dev/api-backend/
 *
 * @author auto-gen
 */
public interface WeChatMiniProgramService {

    /**
     * 获取小程序access_token
     */
    @GET("cgi-bin/token")
    WeChatMiniTokenResp getToken(@Query("grant_type") String grantType,
                                 @Query("appid") String appid,
                                 @Query("secret") String secret);

    /**
     * 登录凭证校验 code2Session
     */
    @GET("sns/jscode2session")
    WeChatMiniCode2SessionResp code2Session(@Query("appid") String appid,
                                            @Query("secret") String secret,
                                            @Query("js_code") String jsCode,
                                            @Query("grant_type") String grantType);

    /**
     * 获取手机号（新版手机号接口，需要access_token + code）
     */
    @POST("wxa/business/getuserphonenumber")
    WeChatMiniPhoneResp getUserPhoneNumber(
            @Body WeChatMiniPhoneReq req);

    class WeChatMiniBaseResp {
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

    class WeChatMiniTokenResp extends WeChatMiniBaseResp {
        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }
    }

    class WeChatMiniCode2SessionResp extends WeChatMiniBaseResp {
        @JsonProperty("openid")
        private String openid;
        @JsonProperty("session_key")
        private String sessionKey;
        @JsonProperty("unionid")
        private String unionid;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }
    }

    class WeChatMiniPhoneReq {
        @JsonProperty("code")
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    class WeChatMiniPhoneInfo {
        @JsonProperty("phoneNumber")
        private String phoneNumber;
        @JsonProperty("purePhoneNumber")
        private String purePhoneNumber;
        @JsonProperty("countryCode")
        private String countryCode;
        @JsonProperty("watermark")
        private Object watermark;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPurePhoneNumber() {
            return purePhoneNumber;
        }

        public void setPurePhoneNumber(String purePhoneNumber) {
            this.purePhoneNumber = purePhoneNumber;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Object getWatermark() {
            return watermark;
        }

        public void setWatermark(Object watermark) {
            this.watermark = watermark;
        }
    }

    class WeChatMiniPhoneResp extends WeChatMiniBaseResp {
        @JsonProperty("phone_info")
        private WeChatMiniPhoneInfo phoneInfo;

        public WeChatMiniPhoneInfo getPhoneInfo() {
            return phoneInfo;
        }

        public void setPhoneInfo(WeChatMiniPhoneInfo phoneInfo) {
            this.phoneInfo = phoneInfo;
        }
    }
}
