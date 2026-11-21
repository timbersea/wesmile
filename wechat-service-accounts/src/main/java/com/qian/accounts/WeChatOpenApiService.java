package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 公众号服务平台 - OpenApi管理接口（额度、RID、重置quota）
 * 官方文档地址：https://developers.weixin.qq.com/doc/service/api/openapi/
 *
 * @author auto-gen
 */
public interface WeChatOpenApiService {

    /**
     * 查询接口调用额度
     * <p>
     * 查询指定接口的调用配额、已使用量、限流阈值。
     *
     * @param req 查询参数
     * @return 额度信息
     */
    @POST("cgi-bin/openapi/quota/get")
    WeChatGetApiQuotaResp getApiQuota(@Body WeChatGetApiQuotaReq req);

    /**
     * 重置指定接口调用次数
     * <p>
     * 清空指定接口的调用计数，恢复调用额度。
     *
     * @param req 重置参数
     * @return 无返回内容
     */
    @POST("cgi-bin/openapi/quota/clear")
    Void clearSpecApiQuota(@Body WeChatClearSpecApiQuotaReq req);

    /**
     * 重置全部接口调用次数（access_token方式）
     * <p>
     * 清空该公众号所有接口的调用计数。
     *
     * @param req 重置参数
     * @return 无返回内容
     */
    @POST("cgi-bin/clear_quota")
    Void clearQuota(@Body WeChatClearQuotaReq req);

    /**
     * 使用AppSecret重置调用次数 v2
     * <p>
     * 无需access_token，直接使用appid+appsecret重置全部额度。
     *
     * @param req 重置参数
     * @return 无返回内容
     */
    @POST("cgi-bin/clear_quota/v2")
    Void clearQuotaByAppSecret(@Body WeChatClearQuotaByAppSecretReq req);

    /**
     * 查询rid错误详情
     * <p>
     * 根据接口返回的rid，查询调用失败的详细原因。
     *
     * @param req rid查询参数
     * @return rid详情
     */
    @POST("cgi-bin/openapi/rid/get")
    WeChatGetRidInfoResp getRidInfo(@Body WeChatGetRidInfoReq req);

    /**
     * 查询接口额度请求参数
     */
    class WeChatGetApiQuotaReq {
        /**
         * 接口路径，如 /cgi-bin/user/info
         */
        @JsonProperty("cgi_path")
        private String cgiPath;

        public String getCgiPath() {
            return cgiPath;
        }

        public void setCgiPath(String cgiPath) {
            this.cgiPath = cgiPath;
        }
    }

    /**
     * 重置指定接口额度请求参数
     */
    class WeChatClearSpecApiQuotaReq {
        /**
         * 接口路径，如 /cgi-bin/user/info
         */
        @JsonProperty("cgi_path")
        private String cgiPath;

        public String getCgiPath() {
            return cgiPath;
        }

        public void setCgiPath(String cgiPath) {
            this.cgiPath = cgiPath;
        }
    }

    /**
     * 重置全部额度请求参数
     */
    class WeChatClearQuotaReq {
        /**
         * 公众号AppID
         */
        private String appid;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }
    }

    /**
     * AppSecret重置额度v2请求参数
     */
    class WeChatClearQuotaByAppSecretReq {
        /**
         * 公众号AppID
         */
        private String appid;
        /**
         * 公众号AppSecret
         */
        private String appsecret;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }
    }

    /**
     * 查询RID详情请求参数
     */
    class WeChatGetRidInfoReq {
        /**
         * 接口调用返回的rid
         */
        private String rid;

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }
    }

    /**
     * 接口额度查询响应
     */
    class WeChatGetApiQuotaResp {
        /**
         * 该接口当日总配额
         */
        private Integer quota;
        /**
         * 当日已调用次数
         */
        private Integer used;
        /**
         * 限流阈值
         */
        @JsonProperty("rate_limit")
        private Integer rateLimit;

        public Integer getQuota() {
            return quota;
        }

        public void setQuota(Integer quota) {
            this.quota = quota;
        }

        public Integer getUsed() {
            return used;
        }

        public void setUsed(Integer used) {
            this.used = used;
        }

        public Integer getRateLimit() {
            return rateLimit;
        }

        public void setRateLimit(Integer rateLimit) {
            this.rateLimit = rateLimit;
        }
    }

    /**
     * RID详情响应
     */
    class WeChatGetRidInfoResp {
        /**
         * 请求唯一标识rid
         */
        private String rid;
        /**
         * 请求时间
         */
        @JsonProperty("request_time")
        private String requestTime;
        /**
         * 响应时间
         */
        @JsonProperty("response_time")
        private String responseTime;
        /**
         * 调用接口名称
         */
        @JsonProperty("api_name")
        private String apiName;
        /**
         * 客户端IP
         */
        private String ip;

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(String requestTime) {
            this.requestTime = requestTime;
        }

        public String getResponseTime() {
            return responseTime;
        }

        public void setResponseTime(String responseTime) {
            this.responseTime = responseTime;
        }

        public String getApiName() {
            return apiName;
        }

        public void setApiName(String apiName) {
            this.apiName = apiName;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
}

