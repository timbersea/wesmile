package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 自动回复接口
 * 官方文档地址：[https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Automatic_reply.html]
 * (https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Automatic_reply.html)
 *
 * @author auto-gen
 */
public interface WeChatAutoReplyService {

    /**
     * 获取自动回复规则
     *
     * @return 自动回复规则结果
     */
    @GET("cgi-bin/get_current_autoreply_info")
    WeChatAutoReplyInfoResp getAutoReplyInfo();

    /**
     * 添加关键词自动回复
     *
     * @param req 请求体
     * @return 操作返回
     */
    @POST("cgi-bin/message/autoreply/add")
    WeChatBaseResp addAutoReply(@Body WeChatAutoReplyAddReq req);

    /**
     * 修改关键词自动回复
     *
     * @param req 请求体
     * @return 操作返回
     */
    @POST("cgi-bin/message/autoreply/update")
    WeChatBaseResp updateAutoReply(@Body WeChatAutoReplyUpdateReq req);

    /**
     * 删除关键词自动回复
     *
     * @param req 请求体
     * @return 操作返回
     */
    @POST("cgi-bin/message/autoreply/delete")
    WeChatBaseResp deleteAutoReply(@Body WeChatAutoReplyDeleteReq req);

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

    class WeChatAutoReplyInfoResp extends WeChatBaseResp {
        @JsonProperty("is_add_friend_reply_open")
        private Integer isAddFriendReplyOpen;
        @JsonProperty("is_autoreply_open")
        private Integer isAutoReplyOpen;
        @JsonProperty("add_friend_reply")
        private WeChatAutoReplyContent addFriendReply;
        @JsonProperty("message_autoreply")
        private WeChatAutoReplyContent messageAutoReply;
        @JsonProperty("keyword_autoreply_info")
        private List<WeChatAutoReplyKeywordItem> keywordAutoReplyInfo;

        public Integer getIsAddFriendReplyOpen() {
            return isAddFriendReplyOpen;
        }

        public void setIsAddFriendReplyOpen(Integer isAddFriendReplyOpen) {
            this.isAddFriendReplyOpen = isAddFriendReplyOpen;
        }

        public Integer getIsAutoReplyOpen() {
            return isAutoReplyOpen;
        }

        public void setIsAutoReplyOpen(Integer isAutoReplyOpen) {
            this.isAutoReplyOpen = isAutoReplyOpen;
        }

        public WeChatAutoReplyContent getAddFriendReply() {
            return addFriendReply;
        }

        public void setAddFriendReply(WeChatAutoReplyContent addFriendReply) {
            this.addFriendReply = addFriendReply;
        }

        public WeChatAutoReplyContent getMessageAutoReply() {
            return messageAutoReply;
        }

        public void setMessageAutoReply(WeChatAutoReplyContent messageAutoReply) {
            this.messageAutoReply = messageAutoReply;
        }

        public List<WeChatAutoReplyKeywordItem> getKeywordAutoReplyInfo() {
            return keywordAutoReplyInfo;
        }

        public void setKeywordAutoReplyInfo(List<WeChatAutoReplyKeywordItem> keywordAutoReplyInfo) {
            this.keywordAutoReplyInfo = keywordAutoReplyInfo;
        }
    }

    class WeChatAutoReplyContent {
        @JsonProperty("type")
        private String type;
        @JsonProperty("content")
        private String content;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    class WeChatAutoReplyKeywordItem {
        @JsonProperty("rule_name")
        private String ruleName;
        @JsonProperty("create_time")
        private Long createTime;
        @JsonProperty("reply_list")
        private List<WeChatAutoReplyContent> replyList;
        @JsonProperty("keyword_list_info")
        private List<WeChatAutoReplyKeyword> keywordListInfo;

        public String getRuleName() {
            return ruleName;
        }

        public void setRuleName(String ruleName) {
            this.ruleName = ruleName;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public List<WeChatAutoReplyContent> getReplyList() {
            return replyList;
        }

        public void setReplyList(List<WeChatAutoReplyContent> replyList) {
            this.replyList = replyList;
        }

        public List<WeChatAutoReplyKeyword> getKeywordListInfo() {
            return keywordListInfo;
        }

        public void setKeywordListInfo(List<WeChatAutoReplyKeyword> keywordListInfo) {
            this.keywordListInfo = keywordListInfo;
        }
    }

    class WeChatAutoReplyKeyword {
        @JsonProperty("keyword")
        private String keyword;
        @JsonProperty("match_type")
        private Integer matchType;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public Integer getMatchType() {
            return matchType;
        }

        public void setMatchType(Integer matchType) {
            this.matchType = matchType;
        }
    }

    class WeChatAutoReplyAddReq {
        @JsonProperty("rule_name")
        private String ruleName;
        @JsonProperty("reply_list")
        private List<WeChatAutoReplyContent> replyList;
        @JsonProperty("keyword_list_info")
        private List<WeChatAutoReplyKeyword> keywordListInfo;

        public String getRuleName() {
            return ruleName;
        }

        public void setRuleName(String ruleName) {
            this.ruleName = ruleName;
        }

        public List<WeChatAutoReplyContent> getReplyList() {
            return replyList;
        }

        public void setReplyList(List<WeChatAutoReplyContent> replyList) {
            this.replyList = replyList;
        }

        public List<WeChatAutoReplyKeyword> getKeywordListInfo() {
            return keywordListInfo;
        }

        public void setKeywordListInfo(List<WeChatAutoReplyKeyword> keywordListInfo) {
            this.keywordListInfo = keywordListInfo;
        }
    }

    class WeChatAutoReplyUpdateReq {
        @JsonProperty("rule_id")
        private Long ruleId;
        @JsonProperty("rule_name")
        private String ruleName;
        @JsonProperty("reply_list")
        private List<WeChatAutoReplyContent> replyList;
        @JsonProperty("keyword_list_info")
        private List<WeChatAutoReplyKeyword> keywordListInfo;

        public Long getRuleId() {
            return ruleId;
        }

        public void setRuleId(Long ruleId) {
            this.ruleId = ruleId;
        }

        public String getRuleName() {
            return ruleName;
        }

        public void setRuleName(String ruleName) {
            this.ruleName = ruleName;
        }

        public List<WeChatAutoReplyContent> getReplyList() {
            return replyList;
        }

        public void setReplyList(List<WeChatAutoReplyContent> replyList) {
            this.replyList = replyList;
        }

        public List<WeChatAutoReplyKeyword> getKeywordListInfo() {
            return keywordListInfo;
        }

        public void setKeywordListInfo(List<WeChatAutoReplyKeyword> keywordListInfo) {
            this.keywordListInfo = keywordListInfo;
        }
    }

    class WeChatAutoReplyDeleteReq {
        @JsonProperty("rule_id")
        private Long ruleId;

        public Long getRuleId() {
            return ruleId;
        }

        public void setRuleId(Long ruleId) {
            this.ruleId = ruleId;
        }
    }
}
