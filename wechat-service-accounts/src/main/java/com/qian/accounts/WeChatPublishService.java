package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 公众号服务平台 - 发布能力接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Publish/Publish.html
 *
 * @author auto-gen
 */
public interface WeChatPublishService {

    /**
     * 发布草稿
     *
     * @param req 草稿media_id
     * @return publish_id
     */
    @POST("cgi-bin/freepublish/submit")
    WeChatPublishSubmitResp submitPublish(
            @Body WeChatPublishSubmitReq req);

    /**
     * 获取发布状态
     *
     * @param req publish_id
     * @return 发布结果
     */
    @POST("cgi-bin/freepublish/get")
    WeChatPublishGetResp getPublish(
            @Body WeChatPublishGetReq req);

    /**
     * 删除已发布文章
     *
     * @param req article_id
     * @return 基础返回
     */
    @POST("cgi-bin/freepublish/delete")
    WeChatBaseResp deletePublish(
            @Body WeChatPublishDeleteReq req);

    /**
     * 通过article_id获取文章详情
     *
     * @param req article_id
     * @return 文章详情
     */
    @POST("cgi-bin/freepublish/getarticle")
    WeChatPublishArticleResp getArticle(
            @Body WeChatPublishArticleReq req);

    /**
     * 获取已发布文章列表
     *
     * @param req offset, count, no_content
     * @return 分页列表
     */
    @POST("cgi-bin/freepublish/batchget")
    WeChatPublishBatchResp batchGetPublish(
            @Body WeChatPublishBatchReq req);

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

    class WeChatPublishSubmitReq {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatPublishSubmitResp extends WeChatBaseResp {
        @JsonProperty("publish_id")
        private String publishId;

        public String getPublishId() {
            return publishId;
        }

        public void setPublishId(String publishId) {
            this.publishId = publishId;
        }
    }

    class WeChatPublishGetReq {
        @JsonProperty("publish_id")
        private String publishId;

        public String getPublishId() {
            return publishId;
        }

        public void setPublishId(String publishId) {
            this.publishId = publishId;
        }
    }

    class WeChatPublishArticle {
        @JsonProperty("article_id")
        private String articleId;
        @JsonProperty("content")
        private WeChatDraftService.WeChatDraftArticle content;

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public WeChatDraftService.WeChatDraftArticle getContent() {
            return content;
        }

        public void setContent(WeChatDraftService.WeChatDraftArticle content) {
            this.content = content;
        }
    }

    class WeChatPublishGetResp extends WeChatBaseResp {
        @JsonProperty("publish_status")
        private Integer publishStatus; // 0成功，1发布中，2失败
        @JsonProperty("article_id")
        private String articleId;
        @JsonProperty("article_detail")
        private WeChatPublishArticle articleDetail;
        @JsonProperty("fail_idx")
        private Integer failIdx;

        public Integer getPublishStatus() {
            return publishStatus;
        }

        public void setPublishStatus(Integer publishStatus) {
            this.publishStatus = publishStatus;
        }

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public WeChatPublishArticle getArticleDetail() {
            return articleDetail;
        }

        public void setArticleDetail(WeChatPublishArticle articleDetail) {
            this.articleDetail = articleDetail;
        }

        public Integer getFailIdx() {
            return failIdx;
        }

        public void setFailIdx(Integer failIdx) {
            this.failIdx = failIdx;
        }
    }

    class WeChatPublishDeleteReq {
        @JsonProperty("article_id")
        private String articleId;

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }
    }

    class WeChatPublishArticleReq {
        @JsonProperty("article_id")
        private String articleId;

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }
    }

    class WeChatPublishArticleResp extends WeChatBaseResp {
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("create_time")
        private Long createTime;
        @JsonProperty("update_time")
        private Long updateTime;

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

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }

    class WeChatPublishBatchReq {
        @JsonProperty("offset")
        private Integer offset;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("no_content")
        private Integer noContent; // 1不返回文章内容，0返回

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getNoContent() {
            return noContent;
        }

        public void setNoContent(Integer noContent) {
            this.noContent = noContent;
        }
    }

    class WeChatPublishBatchItem {
        @JsonProperty("article_id")
        private String articleId;
        @JsonProperty("content")
        private WeChatPublishArticleResp content;
        @JsonProperty("create_time")
        private Long createTime;

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public WeChatPublishArticleResp getContent() {
            return content;
        }

        public void setContent(WeChatPublishArticleResp content) {
            this.content = content;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
    }

    class WeChatPublishBatchResp extends WeChatBaseResp {
        @JsonProperty("total_count")
        private Integer totalCount;
        @JsonProperty("item_count")
        private Integer itemCount;
        @JsonProperty("item")
        private java.util.List<WeChatPublishBatchItem> item;

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getItemCount() {
            return itemCount;
        }

        public void setItemCount(Integer itemCount) {
            this.itemCount = itemCount;
        }

        public java.util.List<WeChatPublishBatchItem> getItem() {
            return item;
        }

        public void setItem(java.util.List<WeChatPublishBatchItem> item) {
            this.item = item;
        }
    }
}

