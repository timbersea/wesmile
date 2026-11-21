package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 基础接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/service/api/base/
 *
 * @author auto-gen
 */
public interface WeChatBaseService {

    /**
     * 获取微信API接口IP地址
     * <p>
     * 该接口用于获取微信服务器的IP地址列表，用于安全校验、白名单配置。
     *
     * @return 包含ip列表的响应实体
     */
    @GET("cgi-bin/get_api_domain_ip")
    WeChatGetApiDomainIpResp getApiDomainIp();

    /**
     * 获取微信回调服务器IP地址
     * <p>
     * 获取微信消息推送、事件回调的服务器IP段，用于业务侧防火墙白名单。
     *
     * @return 包含ip列表的响应实体
     */
    @GET("cgi-bin/getcallbackip")
    WeChatGetCallbackIpResp getCallbackIp();

    /**
     * 网络连通性检测（回调连通检测）
     * <p>
     * 检测微信服务器能否成功访问开发者配置的回调地址。
     *
     * @param req 连通检测请求参数
     * @return 连通检测结果
     */
    @POST("cgi-bin/callback/check")
    WeChatCallbackCheckResp callbackCheck(@Body WeChatCallbackCheckReq req);

    /**
     * 获取稳定版access_token
     * <p>
     * 获取公众号全局接口调用凭证，稳定版access_token不会频繁刷新，适合长期缓存。
     *
     * @param req 获取token请求参数
     * @return access_token响应
     */
    @POST("cgi-bin/stable_token")
    WeChatStableTokenResp getStableToken(@Body WeChatStableTokenReq req);

    /**
     * 连通检测请求参数
     */
    class WeChatCallbackCheckReq {
        /**
         * 检测动作，固定值：all
         */
        private String action;
        /**
         * 回调地址，填写开发者的消息接收URL
         */
        @JsonProperty("check_operator")
        private String checkOperator;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getCheckOperator() {
            return checkOperator;
        }

        public void setCheckOperator(String checkOperator) {
            this.checkOperator = checkOperator;
        }
    }

    /**
     * 获取稳定access_token请求参数
     */
    class WeChatStableTokenReq {
        /**
         * 授权类型，固定为 client_credential
         */
        @JsonProperty("grant_type")
        private String grantType;
        /**
         * 公众号AppID
         */
        private String appid;
        /**
         * 公众号AppSecret
         */
        private String secret;
        /**
         * 是否强制刷新token，true=强制刷新，false=优先返回缓存
         */
        @JsonProperty("force_refresh")
        private Boolean forceRefresh;

        public String getGrantType() {
            return grantType;
        }

        public void setGrantType(String grantType) {
            this.grantType = grantType;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public Boolean getForceRefresh() {
            return forceRefresh;
        }

        public void setForceRefresh(Boolean forceRefresh) {
            this.forceRefresh = forceRefresh;
        }
    }

    /**
     * 获取API服务器IP响应
     */
    class WeChatGetApiDomainIpResp {
        /**
         * IP地址列表
         */
        @JsonProperty("ip_list")
        private List<String> ipList;

        public List<String> getIpList() {
            return ipList;
        }

        public void setIpList(List<String> ipList) {
            this.ipList = ipList;
        }
    }

    /**
     * 获取回调服务器IP响应
     */
    class WeChatGetCallbackIpResp {
        /**
         * IP地址列表
         */
        @JsonProperty("ip_list")
        private List<String> ipList;

        public List<String> getIpList() {
            return ipList;
        }

        public void setIpList(List<String> ipList) {
            this.ipList = ipList;
        }
    }

    /**
     * 连通检测响应
     */
    class WeChatCallbackCheckResp {
        /**
         * 检测结果，ok代表连通正常
         */
        private String result;
        /**
         * 检测详情说明
         */
        private String msg;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    /**
     * 稳定access_token响应
     */
    class WeChatStableTokenResp {
        /**
         * 接口调用凭证
         */
        @JsonProperty("access_token")
        private String accessToken;
        /**
         * 凭证有效时间，单位：秒
         */
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
}

