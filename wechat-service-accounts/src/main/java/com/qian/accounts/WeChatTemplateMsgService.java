package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 模板消息接口
 * 官方文档地址：[https://developers.weixin.qq.com/doc/service/api/template/](https://developers.weixin.qq
 * .com/doc/service/api/template/)
 *
 * @author auto-gen
 */
public interface WeChatTemplateMsgService {
    /**
     * 发送模板消息
     * <p>向指定用户发送模板消息，用于通知类消息。</p>
     *
     * @param req 模板消息发送请求
     * @return 模板消息响应
     */
    @POST("cgi-bin/message/template/send")
    WeChatTemplateSendResp sendTemplateMsg(@Body WeChatTemplateSendReq req);

    /**
     * 设置所属行业
     * <p>设置模板消息所属行业，限制模板可选范围。</p>
     *
     * @param req 设置行业请求
     * @return 无返回内容
     */
    @POST("cgi-bin/template/api_set_industry")
    Void setIndustry(@Body WeChatTemplateSetIndustryReq req);

    /**
     * 获取设置的行业信息
     * <p>查询当前公众号模板消息所属行业。</p>
     *
     * @return 行业信息响应
     */
    @GET("cgi-bin/template/get_industry")
    WeChatTemplateGetIndustryResp getIndustry();

    /**
     * 获得模板ID
     * <p>从行业模板库选择模板，获取template_id。</p>
     *
     * @param req 获取模板id请求
     * @return 模板id响应
     */
    @POST("cgi-bin/template/api_add_template")
    WeChatTemplateAddResp addTemplate(@Body WeChatTemplateAddReq req);

    /**
     * 获取模板列表
     * <p>查询该公众号下所有已添加模板。</p>
     *
     * @return 模板列表响应
     */
    @GET("cgi-bin/template/get_all_private_template")
    WeChatTemplateListResp getTemplateList();

    /**
     * 删除模板
     * <p>删除指定template_id模板。</p>
     *
     * @param req 删除模板请求
     * @return 无返回内容
     */
    @POST("cgi-bin/template/del_private_template")
    Void delTemplate(@Body WeChatTemplateDelReq req);

    class WeChatTemplateSendReq {
        @JsonProperty("touser")
        private String toUser;
        @JsonProperty("template_id")
        private String templateId;
        @JsonProperty("url")
        private String url;
        @JsonProperty("miniprogram")
        private WeChatTemplateMiniProgram miniProgram;
        @JsonProperty("data")
        private Object data;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public WeChatTemplateMiniProgram getMiniProgram() {
            return miniProgram;
        }

        public void setMiniProgram(WeChatTemplateMiniProgram miniProgram) {
            this.miniProgram = miniProgram;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    class WeChatTemplateSendResp {
        @JsonProperty("msgid")
        private Long msgId;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
        }
    }

    class WeChatTemplateMiniProgram {
        @JsonProperty("appid")
        private String appid;
        @JsonProperty("pagepath")
        private String pagePath;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }
    }

    class WeChatTemplateSetIndustryReq {
        @JsonProperty("industry_id1")
        private String industryId1;
        @JsonProperty("industry_id2")
        private String industryId2;

        public String getIndustryId1() {
            return industryId1;
        }

        public void setIndustryId1(String industryId1) {
            this.industryId1 = industryId1;
        }

        public String getIndustryId2() {
            return industryId2;
        }

        public void setIndustryId2(String industryId2) {
            this.industryId2 = industryId2;
        }
    }

    class WeChatTemplateGetIndustryResp {
        @JsonProperty("primary_industry")
        private WeChatTemplateIndustry primaryIndustry;
        @JsonProperty("secondary_industry")
        private WeChatTemplateIndustry secondaryIndustry;

        public WeChatTemplateIndustry getPrimaryIndustry() {
            return primaryIndustry;
        }

        public void setPrimaryIndustry(WeChatTemplateIndustry primaryIndustry) {
            this.primaryIndustry = primaryIndustry;
        }

        public WeChatTemplateIndustry getSecondaryIndustry() {
            return secondaryIndustry;
        }

        public void setSecondaryIndustry(WeChatTemplateIndustry secondaryIndustry) {
            this.secondaryIndustry = secondaryIndustry;
        }
    }

    class WeChatTemplateIndustry {
        @JsonProperty("first_class")
        private String firstClass;
        @JsonProperty("second_class")
        private String secondClass;

        public String getFirstClass() {
            return firstClass;
        }

        public void setFirstClass(String firstClass) {
            this.firstClass = firstClass;
        }

        public String getSecondClass() {
            return secondClass;
        }

        public void setSecondClass(String secondClass) {
            this.secondClass = secondClass;
        }
    }

    class WeChatTemplateAddReq {
        @JsonProperty("template_id_short")
        private String templateIdShort;

        public String getTemplateIdShort() {
            return templateIdShort;
        }

        public void setTemplateIdShort(String templateIdShort) {
            this.templateIdShort = templateIdShort;
        }
    }

    class WeChatTemplateAddResp {
        @JsonProperty("template_id")
        private String templateId;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }
    }

    class WeChatTemplateListResp {
        @JsonProperty("template_list")
        private List<WeChatTemplateItem> templateList;

        public List<WeChatTemplateItem> getTemplateList() {
            return templateList;
        }

        public void setTemplateList(List<WeChatTemplateItem> templateList) {
            this.templateList = templateList;
        }
    }

    class WeChatTemplateItem {
        @JsonProperty("template_id")
        private String templateId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("example")
        private String example;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
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
    }

    class WeChatTemplateDelReq {
        @JsonProperty("template_id")
        private String templateId;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }
    }
}
