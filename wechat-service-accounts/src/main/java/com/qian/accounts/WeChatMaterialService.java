package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 素材管理接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html
 *
 * @author auto-gen
 */
public interface WeChatMaterialService {

    /**
     * 上传永久素材
     *
     * @param req 请求体
     * @return 永久素材上传结果
     */
    @POST("cgi-bin/material/add_material")
    WeChatMaterialAddResp addMaterial(
            @Body WeChatMaterialAddReq req);

    /**
     * 上传图文消息素材
     *
     * @param req 请求体
     * @return 图文素材上传结果
     */
    @POST("cgi-bin/material/add_news")
    WeChatMaterialAddNewsResp addNews(
            @Body WeChatMaterialAddNewsReq req);

    /**
     * 修改图文素材
     *
     * @param req 请求体
     * @return 基础返回
     */
    @POST("cgi-bin/material/update_news")
    WeChatBaseResp updateNews(
            @Body WeChatMaterialUpdateNewsReq req);

    /**
     * 获取素材
     *
     * @param req 请求体
     * @return 素材详情
     */
    @POST("cgi-bin/material/get_material")
    WeChatMaterialGetResp getMaterial(
            @Body WeChatMaterialGetReq req);

    /**
     * 删除永久素材
     *
     * @param req 请求体
     * @return 基础返回
     */
    @POST("cgi-bin/material/del_material")
    WeChatBaseResp delMaterial(
            @Body WeChatMaterialDelReq req);

    /**
     * 获取素材总数
     *
     * @return 素材数量统计
     */
    @GET("cgi-bin/material/get_materialcount")
    WeChatMaterialCountResp getMaterialCount();

    /**
     * 获取素材列表
     *
     * @param req 请求体
     * @return 素材分页列表
     */
    @POST("cgi-bin/material/batchget_material")
    WeChatMaterialBatchResp batchGetMaterial(
            @Body WeChatMaterialBatchReq req);

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

    class WeChatMaterialAddReq {
        @JsonProperty("type")
        private String type;
        @JsonProperty("media")
        private String media;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMedia() {
            return media;
        }

        public void setMedia(String media) {
            this.media = media;
        }
    }

    class WeChatMaterialAddResp extends WeChatBaseResp {
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

    class WeChatMaterialArticle {
        @JsonProperty("title")
        private String title;
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        @JsonProperty("author")
        private String author;
        @JsonProperty("digest")
        private String digest;
        @JsonProperty("show_cover_pic")
        private Integer showCoverPic;
        @JsonProperty("content")
        private String content;
        @JsonProperty("content_source_url")
        private String contentSourceUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContentSourceUrl() {
            return contentSourceUrl;
        }

        public void setContentSourceUrl(String contentSourceUrl) {
            this.contentSourceUrl = contentSourceUrl;
        }
    }

    class WeChatMaterialAddNewsReq {
        @JsonProperty("articles")
        private List<WeChatMaterialArticle> articles;

        public List<WeChatMaterialArticle> getArticles() {
            return articles;
        }

        public void setArticles(List<WeChatMaterialArticle> articles) {
            this.articles = articles;
        }
    }

    class WeChatMaterialAddNewsResp extends WeChatBaseResp {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMaterialUpdateNewsReq {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("articles")
        private WeChatMaterialArticle articles;

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

        public WeChatMaterialArticle getArticles() {
            return articles;
        }

        public void setArticles(WeChatMaterialArticle articles) {
            this.articles = articles;
        }
    }

    class WeChatMaterialGetReq {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMaterialGetResp extends WeChatBaseResp {
        @JsonProperty("news_item")
        private List<WeChatMaterialArticle> newsItem;
        @JsonProperty("video_url")
        private String videoUrl;

        public List<WeChatMaterialArticle> getNewsItem() {
            return newsItem;
        }

        public void setNewsItem(List<WeChatMaterialArticle> newsItem) {
            this.newsItem = newsItem;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }
    }

    class WeChatMaterialDelReq {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMaterialCountResp extends WeChatBaseResp {
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

    class WeChatMaterialBatchReq {
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

    class WeChatMaterialBatchItem {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("name")
        private String name;
        @JsonProperty("update_time")
        private Long updateTime;
        @JsonProperty("url")
        private String url;
        @JsonProperty("content")
        private WeChatMaterialBatchContent content;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public WeChatMaterialBatchContent getContent() {
            return content;
        }

        public void setContent(WeChatMaterialBatchContent content) {
            this.content = content;
        }
    }

    class WeChatMaterialBatchContent {
        @JsonProperty("news_item")
        private List<WeChatMaterialArticle> newsItem;

        public List<WeChatMaterialArticle> getNewsItem() {
            return newsItem;
        }

        public void setNewsItem(List<WeChatMaterialArticle> newsItem) {
            this.newsItem = newsItem;
        }
    }

    class WeChatMaterialBatchResp extends WeChatBaseResp {
        @JsonProperty("total_count")
        private Integer totalCount;
        @JsonProperty("item_count")
        private Integer itemCount;
        @JsonProperty("item")
        private List<WeChatMaterialBatchItem> item;

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

        public List<WeChatMaterialBatchItem> getItem() {
            return item;
        }

        public void setItem(List<WeChatMaterialBatchItem> item) {
            this.item = item;
        }
    }
}
