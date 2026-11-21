package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;
import java.util.Map;

/**
 * 公众号服务平台 - 订阅消息接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/intro.html
 *
 * @author auto-gen
 */
public interface WeChatSubscribeMessageService {

    /**
     * 发送订阅消息
     *
     * @param req 订阅消息请求体
     * @return 基础返回
     */
    @POST("cgi-bin/message/subscribe/send")
    WeChatBaseResp sendSubscribeMessage(
            @Body WeChatSubscribeSendReq req);

    /**
     * 获取模板列表
     *
     * @return 订阅模板列表
     */
    @GET("wxaapi/newtmpl/gettemplate")
    WeChatSubscribeTemplateListResp getTemplateList();

    /**
     * 获取类目
     *
     * @return 类目列表
     */
    @GET("wxaapi/newtmpl/getcategory")
    WeChatSubscribeCategoryResp getCategory();

    /**
     * 获取公共模板关键词
     *
     * @param req 公共模板id请求
     * @return 关键词列表
     */
    @POST("wxaapi/newtmpl/getpubtemplatekeywords")
    WeChatSubscribePubKeywordResp getPubTemplateKeywords(
            @Body WeChatSubscribePubKeywordReq req);

    /**
     * 获取公共模板列表
     *
     * @param req 类目id请求
     * @return 公共模板列表
     */
    @POST("wxaapi/newtmpl/getpubtemplatetitles")
    WeChatSubscribePubTemplateResp getPubTemplateTitles(
            @Body WeChatSubscribePubTemplateReq req);

    /**
     * 添加订阅模板
     *
     * @param req 添加模板请求
     * @return 添加结果
     */
    @POST("wxaapi/newtmpl/addtemplate")
    WeChatSubscribeAddTemplateResp addTemplate(
            @Body WeChatSubscribeAddTemplateReq req);

    /**
     * 删除订阅模板
     *
     * @param req 删除模板请求
     * @return 基础返回
     */
    @POST("wxaapi/newtmpl/deltemplate")
    WeChatBaseResp delTemplate(
            @Body WeChatSubscribeDelTemplateReq req);

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

    class WeChatSubscribeSendReq {
        @JsonProperty("touser")
        private String toUser;
        @JsonProperty("template_id")
        private String templateId;
        @JsonProperty("page")
        private String page;
        @JsonProperty("data")
        private Map<String, WeChatSubscribeDataItem> data;
        @JsonProperty("miniprogram")
        private WeChatSubscribeMiniProgram miniProgram;

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

        public Map<String, WeChatSubscribeDataItem> getData() {
            return data;
        }

        public void setData(Map<String, WeChatSubscribeDataItem> data) {
            this.data = data;
        }

        public WeChatSubscribeMiniProgram getMiniProgram() {
            return miniProgram;
        }

        public void setMiniProgram(WeChatSubscribeMiniProgram miniProgram) {
            this.miniProgram = miniProgram;
        }
    }

    class WeChatSubscribeDataItem {
        @JsonProperty("value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    class WeChatSubscribeMiniProgram {
        @JsonProperty("appid")
        private String appId;
        @JsonProperty("pagepath")
        private String pagePath;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }
    }

    class WeChatSubscribeCategoryItem {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class WeChatSubscribeCategoryResp extends WeChatBaseResp {
        @JsonProperty("data")
        private List<WeChatSubscribeCategoryItem> data;

        public List<WeChatSubscribeCategoryItem> getData() {
            return data;
        }

        public void setData(List<WeChatSubscribeCategoryItem> data) {
            this.data = data;
        }
    }

    class WeChatSubscribePubKeywordReq {
        @JsonProperty("tid")
        private String tid;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }

    class WeChatSubscribeKeywordItem {
        @JsonProperty("kid")
        private Integer kid;
        @JsonProperty("name")
        private String name;
        @JsonProperty("example")
        private String example;

        public Integer getKid() {
            return kid;
        }

        public void setKid(Integer kid) {
            this.kid = kid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }
    }

    class WeChatSubscribePubKeywordResp extends WeChatBaseResp {
        @JsonProperty("data")
        private List<WeChatSubscribeKeywordItem> data;

        public List<WeChatSubscribeKeywordItem> getData() {
            return data;
        }

        public void setData(List<WeChatSubscribeKeywordItem> data) {
            this.data = data;
        }
    }

    class WeChatSubscribePubTemplateReq {
        @JsonProperty("ids")
        private String ids;
        @JsonProperty("start")
        private Integer start;
        @JsonProperty("limit")
        private Integer limit;

        public String getIds() {
            return ids;
        }

        public void setIds(String ids) {
            this.ids = ids;
        }

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }
    }

    class WeChatSubscribePubTemplateItem {
        @JsonProperty("tid")
        private String tid;
        @JsonProperty("title")
        private String title;
        @JsonProperty("type")
        private Integer type;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }

    class WeChatSubscribePubTemplateResp extends WeChatBaseResp {
        @JsonProperty("data")
        private List<WeChatSubscribePubTemplateItem> data;

        public List<WeChatSubscribePubTemplateItem> getData() {
            return data;
        }

        public void setData(List<WeChatSubscribePubTemplateItem> data) {
            this.data = data;
        }
    }

    class WeChatSubscribeAddTemplateReq {
        @JsonProperty("tid")
        private String tid;
        @JsonProperty("kidList")
        private List<Integer> kidList;
        @JsonProperty("sceneDesc")
        private String sceneDesc;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public List<Integer> getKidList() {
            return kidList;
        }

        public void setKidList(List<Integer> kidList) {
            this.kidList = kidList;
        }

        public String getSceneDesc() {
            return sceneDesc;
        }

        public void setSceneDesc(String sceneDesc) {
            this.sceneDesc = sceneDesc;
        }
    }

    class WeChatSubscribeAddTemplateResp extends WeChatBaseResp {
        @JsonProperty("priTmplId")
        private String priTmplId;

        public String getPriTmplId() {
            return priTmplId;
        }

        public void setPriTmplId(String priTmplId) {
            this.priTmplId = priTmplId;
        }
    }

    class WeChatSubscribeDelTemplateReq {
        @JsonProperty("priTmplId")
        private String priTmplId;

        public String getPriTmplId() {
            return priTmplId;
        }

        public void setPriTmplId(String priTmplId) {
            this.priTmplId = priTmplId;
        }
    }

    class WeChatSubscribeTemplateItem {
        @JsonProperty("priTmplId")
        private String priTmplId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("example")
        private String example;
        @JsonProperty("type")
        private Integer type;

        public String getPriTmplId() {
            return priTmplId;
        }

        public void setPriTmplId(String priTmplId) {
            this.priTmplId = priTmplId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }

    class WeChatSubscribeTemplateListResp extends WeChatBaseResp {
        @JsonProperty("data")
        private List<WeChatSubscribeTemplateItem> data;

        public List<WeChatSubscribeTemplateItem> getData() {
            return data;
        }

        public void setData(List<WeChatSubscribeTemplateItem> data) {
            this.data = data;
        }
    }
}
