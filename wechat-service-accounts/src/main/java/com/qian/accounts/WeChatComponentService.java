package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 微信第三方平台（开放平台服务商）接口
 * 文档地址：https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2
 * .0/api/ThirdParty/token/component_access_token.html
 *
 * @author auto-gen
 */
public interface WeChatComponentService {

    /**
     * 获取component_access_token（第三方平台令牌）
     */
    @POST("cgi-bin/component/api_component_token")
    WeChatComponentTokenResp getComponentToken(@Body WeChatComponentTokenReq req);

    /**
     * 获取预授权码（用于公众号授权页面）
     */
    @POST("cgi-bin/component/api_create_preauthcode")
    WeChatComponentPreAuthCodeResp createPreAuthCode(@Query("component_access_token") String componentAccessToken,
                                                     @Body WeChatComponentPreAuthCodeReq req);

    /**
     * 使用授权码换取公众号的授权信息与authorizer_access_token
     */
    @POST("cgi-bin/component/api_query_auth")
    WeChatComponentQueryAuthResp queryAuth(@Query("component_access_token") String componentAccessToken,
                                           @Body WeChatComponentQueryAuthReq req);

    /**
     * 刷新授权方authorizer_access_token
     */
    @POST("cgi-bin/component/api_authorizer_token")
    WeChatComponentAuthorizerTokenResp refreshAuthorizerToken(@Query("component_access_token") String componentAccessToken,
                                                              @Body WeChatComponentAuthorizerTokenReq req);

    /**
     * 获取授权方公众号信息
     */
    @POST("cgi-bin/component/api_get_authorizer_info")
    WeChatComponentAuthorizerInfoResp getAuthorizerInfo(@Query("component_access_token") String componentAccessToken,
                                                        @Body WeChatComponentAuthorizerInfoReq req);

    class WeChatComponentBaseResp {
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

    class WeChatComponentTokenReq {
        @JsonProperty("component_appid")
        private String componentAppid;
        @JsonProperty("component_appsecret")
        private String componentAppSecret;
        @JsonProperty("component_verify_ticket")
        private String componentVerifyTicket;

        public String getComponentAppid() {
            return componentAppid;
        }

        public void setComponentAppid(String componentAppid) {
            this.componentAppid = componentAppid;
        }

        public String getComponentAppSecret() {
            return componentAppSecret;
        }

        public void setComponentAppSecret(String componentAppSecret) {
            this.componentAppSecret = componentAppSecret;
        }

        public String getComponentVerifyTicket() {
            return componentVerifyTicket;
        }

        public void setComponentVerifyTicket(String componentVerifyTicket) {
            this.componentVerifyTicket = componentVerifyTicket;
        }
    }

    class WeChatComponentTokenResp extends WeChatComponentBaseResp {
        @JsonProperty("component_access_token")
        private String componentAccessToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;

        public String getComponentAccessToken() {
            return componentAccessToken;
        }

        public void setComponentAccessToken(String componentAccessToken) {
            this.componentAccessToken = componentAccessToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }
    }

    class WeChatComponentPreAuthCodeReq {
        @JsonProperty("component_appid")
        private String componentAppid;

        public String getComponentAppid() {
            return componentAppid;
        }

        public void setComponentAppid(String componentAppid) {
            this.componentAppid = componentAppid;
        }
    }

    class WeChatComponentPreAuthCodeResp extends WeChatComponentBaseResp {
        @JsonProperty("pre_auth_code")
        private String preAuthCode;
        @JsonProperty("expires_in")
        private Integer expiresIn;

        public String getPreAuthCode() {
            return preAuthCode;
        }

        public void setPreAuthCode(String preAuthCode) {
            this.preAuthCode = preAuthCode;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }
    }

    class WeChatComponentQueryAuthReq {
        @JsonProperty("component_appid")
        private String componentAppid;
        @JsonProperty("authorization_code")
        private String authorizationCode;

        public String getComponentAppid() {
            return componentAppid;
        }

        public void setComponentAppid(String componentAppid) {
            this.componentAppid = componentAppid;
        }

        public String getAuthorizationCode() {
            return authorizationCode;
        }

        public void setAuthorizationCode(String authorizationCode) {
            this.authorizationCode = authorizationCode;
        }
    }

    class WeChatComponentAuthorizationInfo {
        @JsonProperty("authorizer_appid")
        private String authorizerAppid;
        @JsonProperty("authorizer_access_token")
        private String authorizerAccessToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;
        @JsonProperty("authorizer_refresh_token")
        private String authorizerRefreshToken;
        @JsonProperty("func_info")
        private Object funcInfo;

        public String getAuthorizerAppid() {
            return authorizerAppid;
        }

        public void setAuthorizerAppid(String authorizerAppid) {
            this.authorizerAppid = authorizerAppid;
        }

        public String getAuthorizerAccessToken() {
            return authorizerAccessToken;
        }

        public void setAuthorizerAccessToken(String authorizerAccessToken) {
            this.authorizerAccessToken = authorizerAccessToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getAuthorizerRefreshToken() {
            return authorizerRefreshToken;
        }

        public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
            this.authorizerRefreshToken = authorizerRefreshToken;
        }

        public Object getFuncInfo() {
            return funcInfo;
        }

        public void setFuncInfo(Object funcInfo) {
            this.funcInfo = funcInfo;
        }
    }

    class WeChatComponentQueryAuthResp extends WeChatComponentBaseResp {
        @JsonProperty("authorization_info")
        private WeChatComponentAuthorizationInfo authorizationInfo;

        public WeChatComponentAuthorizationInfo getAuthorizationInfo() {
            return authorizationInfo;
        }

        public void setAuthorizationInfo(WeChatComponentAuthorizationInfo authorizationInfo) {
            this.authorizationInfo = authorizationInfo;
        }
    }

    class WeChatComponentAuthorizerTokenReq {
        @JsonProperty("component_appid")
        private String componentAppid;
        @JsonProperty("authorizer_appid")
        private String authorizerAppid;
        @JsonProperty("authorizer_refresh_token")
        private String authorizerRefreshToken;

        public String getComponentAppid() {
            return componentAppid;
        }

        public void setComponentAppid(String componentAppid) {
            this.componentAppid = componentAppid;
        }

        public String getAuthorizerAppid() {
            return authorizerAppid;
        }

        public void setAuthorizerAppid(String authorizerAppid) {
            this.authorizerAppid = authorizerAppid;
        }

        public String getAuthorizerRefreshToken() {
            return authorizerRefreshToken;
        }

        public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
            this.authorizerRefreshToken = authorizerRefreshToken;
        }
    }

    class WeChatComponentAuthorizerTokenResp extends WeChatComponentBaseResp {
        @JsonProperty("authorizer_access_token")
        private String authorizerAccessToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;
        @JsonProperty("authorizer_refresh_token")
        private String authorizerRefreshToken;

        public String getAuthorizerAccessToken() {
            return authorizerAccessToken;
        }

        public void setAuthorizerAccessToken(String authorizerAccessToken) {
            this.authorizerAccessToken = authorizerAccessToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getAuthorizerRefreshToken() {
            return authorizerRefreshToken;
        }

        public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
            this.authorizerRefreshToken = authorizerRefreshToken;
        }
    }

    class WeChatComponentAuthorizerInfoReq {
        @JsonProperty("component_appid")
        private String componentAppid;
        @JsonProperty("authorizer_appid")
        private String authorizerAppid;

        public String getComponentAppid() {
            return componentAppid;
        }

        public void setComponentAppid(String componentAppid) {
            this.componentAppid = componentAppid;
        }

        public String getAuthorizerAppid() {
            return authorizerAppid;
        }

        public void setAuthorizerAppid(String authorizerAppid) {
            this.authorizerAppid = authorizerAppid;
        }
    }

    class WeChatComponentAuthorizerInfoResp extends WeChatComponentBaseResp {
        @JsonProperty("authorizer_info")
        private Object authorizerInfo;
        @JsonProperty("authorization_info")
        private Object authorizationInfo;

        public Object getAuthorizerInfo() {
            return authorizerInfo;
        }

        public void setAuthorizerInfo(Object authorizerInfo) {
            this.authorizerInfo = authorizerInfo;
        }

        public Object getAuthorizationInfo() {
            return authorizationInfo;
        }

        public void setAuthorizationInfo(Object authorizationInfo) {
            this.authorizationInfo = authorizationInfo;
        }
    }
}
