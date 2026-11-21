package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 草稿箱接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Draft_Box/Add_draft.html
 *
 * @author auto-gen
 */
public interface WeChatDraftService {

    /**
     * 新增草稿
     *
     * @param req 草稿图文内容
     * @return media_id
     */
    @POST("cgi-bin/draft/add")
    WeChatDraftAddResp addDraft(
            @Body WeChatDraftAddReq req);

    /**
     * 获取草稿
     *
     * @param req media_id
     * @return 草稿详情
     */
    @POST("cgi-bin/draft/get")
    WeChatDraftGetResp getDraft(
            @Body WeChatDraftGetReq req);

    /**
     * 删除草稿
     *
     * @param req media_id
     * @return 基础返回
     */
    @POST("cgi-bin/draft/delete")
    WeChatBaseResp deleteDraft(
            @Body WeChatDraftGetReq req);

    /**
     * 修改草稿
     *
     * @param req media_id + index + 新文章内容
     * @return 基础返回
     */
    @POST("cgi-bin/draft/update")
    WeChatBaseResp updateDraft(
            @Body WeChatDraftUpdateReq req);

    /**
     * 获取草稿总数
     *
     * @return 草稿数量
     */
    @GET("cgi-bin/draft/count")
    WeChatDraftCountResp getDraftCount();

    /**
     * 获取草稿列表
     *
     * @param req offset count no_content
     * @return 草稿分页列表
     */
    @POST("cgi-bin/draft/batchget")
    WeChatDraftBatchResp batchGetDraft(
            @Body WeChatDraftBatchReq req);

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

    class WeChatDraftArticle {
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        @JsonProperty("author")
        private String author;
        @JsonProperty("title")
        private String title;
        @JsonProperty("content_source_url")
        private String contentSourceUrl;
        @JsonProperty("content")
        private String content;
        @JsonProperty("digest")
        private String digest;
        @JsonProperty("show_cover_pic")
        private Integer showCoverPic;
        @JsonProperty("need_open_comment")
        private Integer needOpenComment;
        @JsonProperty("only_fans_can_comment")
        private Integer onlyFansCanComment;

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContentSourceUrl() {
            return contentSourceUrl;
        }

        public void setContentSourceUrl(String contentSourceUrl) {
            this.contentSourceUrl = contentSourceUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public Integer getShowCoverPic() {
            return showCoverPic;
        }

        public void setShowCoverPic(Integer showCoverPic) {
            this.showCoverPic = showCoverPic;
        }

        public Integer getNeedOpenComment() {
            return needOpenComment;
        }

        public void setNeedOpenComment(Integer needOpenComment) {
            this.needOpenComment = needOpenComment;
        }

        public Integer getOnlyFansCanComment() {
            return onlyFansCanComment;
        }

        public void setOnlyFansCanComment(Integer onlyFansCanComment) {
            this.onlyFansCanComment = onlyFansCanComment;
        }
    }

    class WeChatDraftAddReq {
        @JsonProperty("articles")
        private List<WeChatDraftArticle> articles;

        public List<WeChatDraftArticle> getArticles() {
            return articles;
        }

        public void setArticles(List<WeChatDraftArticle> articles) {
            this.articles = articles;
        }
    }

    class WeChatDraftAddResp extends WeChatBaseResp {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatDraftGetReq {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatDraftGetResp extends WeChatBaseResp {
        @JsonProperty("articles")
        private List<WeChatDraftArticle> articles;
        @JsonProperty("create_time")
        private Long createTime;
        @JsonProperty("update_time")
        private Long updateTime;

        public List<WeChatDraftArticle> getArticles() {
            return articles;
        }

        public void setArticles(List<WeChatDraftArticle> articles) {
            this.articles = articles;
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

    class WeChatDraftUpdateReq {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("articles")
        private WeChatDraftArticle articles;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public WeChatDraftArticle getArticles() {
            return articles;
        }

        public void setArticles(WeChatDraftArticle articles) {
            this.articles = articles;
        }
    }

    class WeChatDraftCountResp extends WeChatBaseResp {
        @JsonProperty("total_count")
        private Integer totalCount;

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }
    }

    class WeChatDraftBatchReq {
        @JsonProperty("offset")
        private Integer offset;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("no_content")
        private Integer noContent; // 1不返回article内容，0返回

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

    class WeChatDraftItem {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("content")
        private WeChatDraftGetResp content;
        @JsonProperty("create_time")
        private Long createTime;
        @JsonProperty("update_time")
        private Long updateTime;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public WeChatDraftGetResp getContent() {
            return content;
        }

        public void setContent(WeChatDraftGetResp content) {
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

    class WeChatDraftBatchResp extends WeChatBaseResp {
        @JsonProperty("total_count")
        private Integer totalCount;
        @JsonProperty("item_count")
        private Integer itemCount;
        @JsonProperty("item")
        private List<WeChatDraftItem> item;

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

        public List<WeChatDraftItem> getItem() {
            return item;
        }

        public void setItem(List<WeChatDraftItem> item) {
            this.item = item;
        }
    }
}

