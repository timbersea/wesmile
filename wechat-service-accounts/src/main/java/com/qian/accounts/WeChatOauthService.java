package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 公众号服务平台 - 网页授权OAuth2接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html
 *
 * @author auto-gen
 */
public interface WeChatOauthService {

    /**
     * 通过code换取网页授权access_token
     *
     * @param appId     公众号appid
     * @param appSecret 公众号appsecret
     * @param code      前端回调拿到的code
     * @param grantType 固定值 authorization_code
     * @return 授权token、openid
     */
    @GET("sns/oauth2/access_token")
    WeChatOauthTokenResp getOauthAccessToken(@Query("appid") String appId,
                                             @Query("secret") String appSecret,
                                             @Query("code") String code,
                                             @Query("grant_type") String grantType);

    /**
     * 刷新网页授权access_token
     *
     * @param appId        公众号appid
     * @param grantType    固定值 refresh_token
     * @param refreshToken 上一步返回的refresh_token
     * @return 新的授权token信息
     */
    @GET("sns/oauth2/refresh_token")
    WeChatOauthTokenResp refreshOauthToken(@Query("appid") String appId,
                                           @Query("grant_type") String grantType,
                                           @Query("refresh_token") String refreshToken);

    /**
     * 拉取用户信息（scope=snsapi_userinfo）
     *
     * @param accessToken 网页授权access_token（不是全局token）
     * @param openid      用户openid
     * @param lang        语言 zh_CN / zh_TW / en
     * @return 用户信息
     */
    @GET("sns/userinfo")
    WeChatOauthUserInfoResp getOauthUserInfo(
            @Query("openid") String openid,
            @Query("lang") String lang);

    /**
     * 检验网页授权access_token是否有效
     *
     * @param accessToken 网页授权access_token
     * @param openid      用户openid
     * @return 校验结果
     */
    @GET("sns/auth")
    WeChatBaseResp checkOauthToken(
            @Query("openid") String openid);

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

    class WeChatOauthTokenResp extends WeChatBaseResp {
        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;
        @JsonProperty("refresh_token")
        private String refreshToken;
        @JsonProperty("openid")
        private String openid;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("unionid")
        private String unionid;

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

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }
    }

    class WeChatOauthUserInfoResp extends WeChatBaseResp {
        @JsonProperty("openid")
        private String openid;
        @JsonProperty("nickname")
        private String nickname;
        @JsonProperty("sex")
        private Integer sex;
        @JsonProperty("province")
        private String province;
        @JsonProperty("city")
        private String city;
        @JsonProperty("country")
        private String country;
        @JsonProperty("headimgurl")
        private String headImgUrl;
        @JsonProperty("privilege")
        private String[] privilege;
        @JsonProperty("unionid")
        private String unionid;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public String[] getPrivilege() {
            return privilege;
        }

        public void setPrivilege(String[] privilege) {
            this.privilege = privilege;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }
    }
}

