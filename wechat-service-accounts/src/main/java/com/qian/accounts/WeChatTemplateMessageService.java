package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;
import java.util.Map;

/**
 * 公众号服务平台 - 模板消息接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html
 *
 * @author auto-gen
 */
public interface WeChatTemplateMessageService {

    /**
     * 发送模板消息
     *
     * @param req 模板消息请求体
     * @return 发送结果
     */
    @POST("cgi-bin/message/template/send")
    WeChatTemplateSendResp sendTemplateMessage(
            @Body WeChatTemplateSendReq req);

    /**
     * 设置所属行业
     *
     * @param req 行业设置请求
     * @return 基础返回
     */
    @POST("cgi-bin/template/api_set_industry")
    WeChatBaseResp setIndustry(
            @Body WeChatTemplateSetIndustryReq req);

    /**
     * 获取设置的行业信息
     *
     * @return 行业信息
     */
    @GET("cgi-bin/template/get_industry")
    WeChatTemplateIndustryResp getIndustry();

    /**
     * 获取模板ID
     *
     * @param req 模板编号请求
     * @return 获取模板结果
     */
    @POST("cgi-bin/template/api_add_template")
    WeChatTemplateAddResp addTemplate(
            @Body WeChatTemplateAddReq req);

    /**
     * 获取模板列表
     *
     * @return 已添加模板列表
     */
    @GET("cgi-bin/template/get_all_private_template")
    WeChatTemplateListResp getAllPrivateTemplate();

    /**
     * 删除模板
     *
     * @param req 删除模板请求
     * @return 基础返回
     */
    @POST("cgi-bin/template/del_private_template")
    WeChatBaseResp delPrivateTemplate(
            @Body WeChatTemplateDelReq req);

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
        private Map<String, WeChatTemplateDataItem> data;

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

        public Map<String, WeChatTemplateDataItem> getData() {
            return data;
        }

        public void setData(Map<String, WeChatTemplateDataItem> data) {
            this.data = data;
        }
    }

    class WeChatTemplateDataItem {
        @JsonProperty("value")
        private String value;
        @JsonProperty("color")
        private String color;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    class WeChatTemplateMiniProgram {
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

    class WeChatTemplateSendResp extends WeChatBaseResp {
        @JsonProperty("msgid")
        private Long msgId;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
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

    class WeChatTemplateIndustry {
        @JsonProperty("industry_id")
        private String industryId;
        @JsonProperty("industry_name")
        private String industryName;

        public String getIndustryId() {
            return industryId;
        }

        public void setIndustryId(String industryId) {
            this.industryId = industryId;
        }

        public String getIndustryName() {
            return industryName;
        }

        public void setIndustryName(String industryName) {
            this.industryName = industryName;
        }
    }

    class WeChatTemplateIndustryResp extends WeChatBaseResp {
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

    class WeChatTemplateAddResp extends WeChatBaseResp {
        @JsonProperty("template_id")
        private String templateId;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
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

    class WeChatTemplateListResp extends WeChatBaseResp {
        @JsonProperty("template_list")
        private List<WeChatTemplateItem> templateList;

        public List<WeChatTemplateItem> getTemplateList() {
            return templateList;
        }

        public void setTemplateList(List<WeChatTemplateItem> templateList) {
            this.templateList = templateList;
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