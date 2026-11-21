package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 客服消息接口
 * 官方文档地址：[https://developers.weixin.qq.com/doc/service/api/kf/](https://developers.weixin.qq.com/doc/service/api/kf/)
 *
 * @author auto-gen
 */
public interface WeChatKfService {
    /**
     * 发送客服消息
     * <p>当用户和公众号产生交互的48小时内，可以主动发送客服消息。</p>
     *
     * @param req 客服消息请求
     * @return 无返回内容
     */
    @POST("cgi-bin/message/custom/send")
    Void sendCustomMsg(@Body WeChatKfSendReq req);

    /**
     * 获取客服列表
     * <p>获取公众号所有客服账号。</p>
     *
     * @return 客服列表响应
     */
    @GET("cgi-bin/customservice/getkflist")
    WeChatKfListResp getKfList();

    /**
     * 获取在线客服列表
     * <p>获取当前在线的客服。</p>
     *
     * @return 在线客服列表响应
     */
    @GET("cgi-bin/customservice/getonlinekflist")
    WeChatKfOnlineListResp getOnlineKfList();

    class WeChatKfSendReq {
        @JsonProperty("touser")
        private String toUser;
        @JsonProperty("msgtype")
        private String msgType;
        @JsonProperty("text")
        private WeChatKfText text;
        @JsonProperty("image")
        private WeChatKfImage image;
        @JsonProperty("voice")
        private WeChatKfVoice voice;
        @JsonProperty("video")
        private WeChatKfVideo video;
        @JsonProperty("music")
        private WeChatKfMusic music;
        @JsonProperty("news")
        private WeChatKfNews news;
        @JsonProperty("mpnews")
        private WeChatKfMpNews mpNews;
        @JsonProperty("kf_account")
        private String kfAccount;

        public String getToUser() {
            return toUser;
        }

        public void setToUser(String toUser) {
            this.toUser = toUser;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public WeChatKfText getText() {
            return text;
        }

        public void setText(WeChatKfText text) {
            this.text = text;
        }

        public WeChatKfImage getImage() {
            return image;
        }

        public void setImage(WeChatKfImage image) {
            this.image = image;
        }

        public WeChatKfVoice getVoice() {
            return voice;
        }

        public void setVoice(WeChatKfVoice voice) {
            this.voice = voice;
        }

        public WeChatKfVideo getVideo() {
            return video;
        }

        public void setVideo(WeChatKfVideo video) {
            this.video = video;
        }

        public WeChatKfMusic getMusic() {
            return music;
        }

        public void setMusic(WeChatKfMusic music) {
            this.music = music;
        }

        public WeChatKfNews getNews() {
            return news;
        }

        public void setNews(WeChatKfNews news) {
            this.news = news;
        }

        public WeChatKfMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatKfMpNews mpNews) {
            this.mpNews = mpNews;
        }

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }
    }

    class WeChatKfText {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    class WeChatKfImage {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatKfVoice {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatKfVideo {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        private String title;
        private String description;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    class WeChatKfMusic {
        @JsonProperty("musicurl")
        private String musicUrl;
        @JsonProperty("hqmusicurl")
        private String hqMusicUrl;
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        private String title;
        private String description;

        public String getMusicUrl() {
            return musicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
        }

        public String getHqMusicUrl() {
            return hqMusicUrl;
        }

        public void setHqMusicUrl(String hqMusicUrl) {
            this.hqMusicUrl = hqMusicUrl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    class WeChatKfNews {
        @JsonProperty("articles")
        private List<WeChatKfNewsItem> articles;

        public List<WeChatKfNewsItem> getArticles() {
            return articles;
        }

        public void setArticles(List<WeChatKfNewsItem> articles) {
            this.articles = articles;
        }
    }

    class WeChatKfNewsItem {
        private String title;
        private String description;
        private String url;
        @JsonProperty("picurl")
        private String picUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }

    class WeChatKfMpNews {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatKfListResp {
        @JsonProperty("kf_list")
        private List<WeChatKfItem> kfList;

        public List<WeChatKfItem> getKfList() {
            return kfList;
        }

        public void setKfList(List<WeChatKfItem> kfList) {
            this.kfList = kfList;
        }
    }

    class WeChatKfOnlineListResp {
        @JsonProperty("kf_online_list")
        private List<WeChatKfOnlineItem> kfOnlineList;

        public List<WeChatKfOnlineItem> getKfOnlineList() {
            return kfOnlineList;
        }

        public void setKfOnlineList(List<WeChatKfOnlineItem> kfOnlineList) {
            this.kfOnlineList = kfOnlineList;
        }
    }

    class WeChatKfItem {
        @JsonProperty("kf_account")
        private String kfAccount;
        @JsonProperty("kf_nick")
        private String kfNick;
        @JsonProperty("kf_id")
        private Integer kfId;
        @JsonProperty("kf_headimgurl")
        private String kfHeadImgUrl;

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }

        public String getKfNick() {
            return kfNick;
        }

        public void setKfNick(String kfNick) {
            this.kfNick = kfNick;
        }

        public Integer getKfId() {
            return kfId;
        }

        public void setKfId(Integer kfId) {
            this.kfId = kfId;
        }

        public String getKfHeadImgUrl() {
            return kfHeadImgUrl;
        }

        public void setKfHeadImgUrl(String kfHeadImgUrl) {
            this.kfHeadImgUrl = kfHeadImgUrl;
        }
    }

    class WeChatKfOnlineItem {
        @JsonProperty("kf_account")
        private String kfAccount;
        @JsonProperty("status")
        private Integer status;
        @JsonProperty("kf_id")
        private Integer kfId;
        @JsonProperty("kf_headimgurl")
        private String kfHeadImgUrl;

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getKfId() {
            return kfId;
        }

        public void setKfId(Integer kfId) {
            this.kfId = kfId;
        }

        public String getKfHeadImgUrl() {
            return kfHeadImgUrl;
        }

        public void setKfHeadImgUrl(String kfHeadImgUrl) {
            this.kfHeadImgUrl = kfHeadImgUrl;
        }
    }
}