package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * 公众号服务平台 - 素材管理接口
 * 官方文档地址：[https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html]
 * (https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html)
 *
 * @author auto-gen
 */
public interface WeChatMediaService {

    /**
     * 上传临时素材（form表单上传，retrofit需Multipart）
     */
    @POST("cgi-bin/media/upload")
    WeChatMediaUploadTempResp uploadTempMedia(
            @Query("type") String type);

    /**
     * 获取临时素材
     */
    @GET("cgi-bin/media/get")
    void getTempMedia(
            @Query("media_id") String mediaId);

    /**
     * 上传永久素材（图文除外）
     */
    @POST("cgi-bin/material/add_material")
    WeChatMediaAddMaterialResp addMaterial(
            @Query("type") String type);

    /**
     * 新增永久图文素材
     */
    @POST("cgi-bin/material/add_news")
    WeChatMediaAddNewsResp addNews(
            @Body WeChatMediaAddNewsReq req);

    /**
     * 获取永久素材
     */
    @POST("cgi-bin/material/get_material")
    WeChatMediaGetMaterialResp getMaterial(
            @Body WeChatMediaGetMaterialReq req);

    /**
     * 删除永久素材
     */
    @POST("cgi-bin/material/del_material")
    WeChatBaseResp delMaterial(
            @Body WeChatMediaDelMaterialReq req);

    /**
     * 修改永久图文素材
     */
    @POST("cgi-bin/material/update_news")
    WeChatBaseResp updateNews(
            @Body WeChatMediaUpdateNewsReq req);

    /**
     * 获取素材总数
     */
    @GET("cgi-bin/material/get_materialcount")
    WeChatMediaCountResp getMaterialCount();

    /**
     * 获取素材列表
     */
    @POST("cgi-bin/material/batchget_material")
    WeChatMediaBatchGetResp batchGetMaterial(
            @Body WeChatMediaBatchGetReq req);

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

    class WeChatMediaUploadTempResp extends WeChatBaseResp {
        @JsonProperty("type")
        private String type;
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("created_at")
        private Long createdAt;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public Long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Long createdAt) {
            this.createdAt = createdAt;
        }
    }

    class WeChatMediaAddMaterialResp extends WeChatBaseResp {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("url")
        private String url;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    class WeChatMediaArticle {
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

    class WeChatMediaAddNewsReq {
        @JsonProperty("articles")
        private List<WeChatMediaArticle> articles;

        public List<WeChatMediaArticle> getArticles() {
            return articles;
        }

        public void setArticles(List<WeChatMediaArticle> articles) {
            this.articles = articles;
        }
    }

    class WeChatMediaAddNewsResp extends WeChatBaseResp {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMediaGetMaterialReq {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMediaGetMaterialResp extends WeChatBaseResp {
        @JsonProperty("news_item")
        private List<WeChatMediaArticle> newsItem;
        @JsonProperty("url")
        private String url;

        public List<WeChatMediaArticle> getNewsItem() {
            return newsItem;
        }

        public void setNewsItem(List<WeChatMediaArticle> newsItem) {
            this.newsItem = newsItem;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    class WeChatMediaDelMaterialReq {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMediaUpdateNewsReq {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("articles")
        private WeChatMediaArticle articles;

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

        public WeChatMediaArticle getArticles() {
            return articles;
        }

        public void setArticles(WeChatMediaArticle articles) {
            this.articles = articles;
        }
    }

    class WeChatMediaCountResp extends WeChatBaseResp {
        @JsonProperty("voice_count")
        private Integer voiceCount;
        @JsonProperty("video_count")
        private Integer videoCount;
        @JsonProperty("image_count")
        private Integer imageCount;
        @JsonProperty("news_count")
        private Integer newsCount;

        public Integer getVoiceCount() {
            return voiceCount;
        }

        public void setVoiceCount(Integer voiceCount) {
            this.voiceCount = voiceCount;
        }

        public Integer getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(Integer videoCount) {
            this.videoCount = videoCount;
        }

        public Integer getImageCount() {
            return imageCount;
        }

        public void setImageCount(Integer imageCount) {
            this.imageCount = imageCount;
        }

        public Integer getNewsCount() {
            return newsCount;
        }

        public void setNewsCount(Integer newsCount) {
            this.newsCount = newsCount;
        }
    }

    class WeChatMediaBatchGetReq {
        @JsonProperty("type")
        private String type;
        @JsonProperty("offset")
        private Integer offset;
        @JsonProperty("count")
        private Integer count;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

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
    }

    class WeChatMediaBatchItem {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("content")
        private WeChatMediaBatchContent content;
        @JsonProperty("update_time")
        private Long updateTime;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public WeChatMediaBatchContent getContent() {
            return content;
        }

        public void setContent(WeChatMediaBatchContent content) {
            this.content = content;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }

    class WeChatMediaBatchContent {
        @JsonProperty("news_item")
        private List<WeChatMediaArticle> newsItem;
        @JsonProperty("url")
        private String url;

        public List<WeChatMediaArticle> getNewsItem() {
            return newsItem;
        }

        public void setNewsItem(List<WeChatMediaArticle> newsItem) {
            this.newsItem = newsItem;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    class WeChatMediaBatchGetResp extends WeChatBaseResp {
        @JsonProperty("total_count")
        private Integer totalCount;
        @JsonProperty("item_count")
        private Integer itemCount;
        @JsonProperty("item")
        private List<WeChatMediaBatchItem> item;

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

        public List<WeChatMediaBatchItem> getItem() {
            return item;
        }

        public void setItem(List<WeChatMediaBatchItem> item) {
            this.item = item;
        }
    }
}
