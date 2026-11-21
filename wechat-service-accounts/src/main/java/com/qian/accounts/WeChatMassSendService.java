package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 群发与发布接口
 * 官方文档地址：[https://developers.weixin.qq.com/doc/service/api/masssend/](https://developers.weixin.qq
 * .com/doc/service/api/masssend/)
 *
 * @author auto-gen
 */
public interface WeChatMassSendService {
    /**
     * 根据标签进行群发
     * <p>开发者可以通过该接口对指定标签分组用户进行群发消息。</p>
     *
     * @param req 标签群发请求
     * @return 群发响应
     */
    @POST("cgi-bin/message/mass/sendall")
    WeChatMassSendResp massSendAll(@Body WeChatMassSendAllReq req);

    /**
     * 根据OpenID列表群发
     * <p>向指定openid列表用户群发消息，一次最多10000个openid。</p>
     *
     * @param req openid群发请求
     * @return 群发响应
     */
    @POST("cgi-bin/message/mass/send")
    WeChatMassSendResp massSend(@Body WeChatMassSendReq req);

    /**
     * 删除群发
     * <p>删除已群发的消息，用户侧仍然保留，只是后台不再展示。</p>
     *
     * @param req 删除群发请求
     * @return 无返回内容
     */
    @POST("cgi-bin/message/mass/delete")
    Void deleteMass(@Body WeChatMassDeleteReq req);

    /**
     * 预览群发消息
     * <p>发送消息给指定openid，用于预览效果。</p>
     *
     * @param req 预览请求
     * @return 预览响应
     */
    @POST("cgi-bin/message/mass/preview")
    WeChatMassPreviewResp massPreview(@Body WeChatMassPreviewReq req);

    /**
     * 查询群发消息发送状态
     * <p>根据msg_id查询群发任务发送进度。</p>
     *
     * @param req 查询群发状态请求
     * @return 群发状态响应
     */
    @POST("cgi-bin/message/mass/get")
    WeChatMassGetResp getMassStatus(@Body WeChatMassGetReq req);

    class WeChatMassSendAllReq {
        @JsonProperty("filter")
        private WeChatMassFilter filter;
        @JsonProperty("msgtype")
        private String msgType;
        @JsonProperty("text")
        private WeChatMassText text;
        @JsonProperty("image")
        private WeChatMassImage image;
        @JsonProperty("mpnews")
        private WeChatMassMpNews mpNews;
        @JsonProperty("voice")
        private WeChatMassVoice voice;
        @JsonProperty("video")
        private WeChatMassVideo video;
        @JsonProperty("send_ignore_reprint")
        private Integer sendIgnoreReprint;

        public WeChatMassFilter getFilter() {
            return filter;
        }

        public void setFilter(WeChatMassFilter filter) {
            this.filter = filter;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public WeChatMassText getText() {
            return text;
        }

        public void setText(WeChatMassText text) {
            this.text = text;
        }

        public WeChatMassImage getImage() {
            return image;
        }

        public void setImage(WeChatMassImage image) {
            this.image = image;
        }

        public WeChatMassMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatMassMpNews mpNews) {
            this.mpNews = mpNews;
        }

        public WeChatMassVoice getVoice() {
            return voice;
        }

        public void setVoice(WeChatMassVoice voice) {
            this.voice = voice;
        }

        public WeChatMassVideo getVideo() {
            return video;
        }

        public void setVideo(WeChatMassVideo video) {
            this.video = video;
        }

        public Integer getSendIgnoreReprint() {
            return sendIgnoreReprint;
        }

        public void setSendIgnoreReprint(Integer sendIgnoreReprint) {
            this.sendIgnoreReprint = sendIgnoreReprint;
        }
    }

    class WeChatMassSendReq {
        @JsonProperty("touser")
        private List<String> toUser;
        @JsonProperty("msgtype")
        private String msgType;
        @JsonProperty("text")
        private WeChatMassText text;
        @JsonProperty("image")
        private WeChatMassImage image;
        @JsonProperty("mpnews")
        private WeChatMassMpNews mpNews;
        @JsonProperty("voice")
        private WeChatMassVoice voice;
        @JsonProperty("video")
        private WeChatMassVideo video;
        @JsonProperty("send_ignore_reprint")
        private Integer sendIgnoreReprint;

        public List<String> getToUser() {
            return toUser;
        }

        public void setToUser(List<String> toUser) {
            this.toUser = toUser;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public WeChatMassText getText() {
            return text;
        }

        public void setText(WeChatMassText text) {
            this.text = text;
        }

        public WeChatMassImage getImage() {
            return image;
        }

        public void setImage(WeChatMassImage image) {
            this.image = image;
        }

        public WeChatMassMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatMassMpNews mpNews) {
            this.mpNews = mpNews;
        }

        public WeChatMassVoice getVoice() {
            return voice;
        }

        public void setVoice(WeChatMassVoice voice) {
            this.voice = voice;
        }

        public WeChatMassVideo getVideo() {
            return video;
        }

        public void setVideo(WeChatMassVideo video) {
            this.video = video;
        }

        public Integer getSendIgnoreReprint() {
            return sendIgnoreReprint;
        }

        public void setSendIgnoreReprint(Integer sendIgnoreReprint) {
            this.sendIgnoreReprint = sendIgnoreReprint;
        }
    }

    class WeChatMassDeleteReq {
        @JsonProperty("msg_id")
        private Long msgId;
        @JsonProperty("article_idx")
        private Integer articleIdx;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
        }

        public Integer getArticleIdx() {
            return articleIdx;
        }

        public void setArticleIdx(Integer articleIdx) {
            this.articleIdx = articleIdx;
        }
    }

    class WeChatMassPreviewReq {
        @JsonProperty("touser")
        private String toUser;
        @JsonProperty("msgtype")
        private String msgType;
        @JsonProperty("text")
        private WeChatMassText text;
        @JsonProperty("image")
        private WeChatMassImage image;
        @JsonProperty("mpnews")
        private WeChatMassMpNews mpNews;
        @JsonProperty("voice")
        private WeChatMassVoice voice;
        @JsonProperty("video")
        private WeChatMassVideo video;

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

        public WeChatMassText getText() {
            return text;
        }

        public void setText(WeChatMassText text) {
            this.text = text;
        }

        public WeChatMassImage getImage() {
            return image;
        }

        public void setImage(WeChatMassImage image) {
            this.image = image;
        }

        public WeChatMassMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatMassMpNews mpNews) {
            this.mpNews = mpNews;
        }

        public WeChatMassVoice getVoice() {
            return voice;
        }

        public void setVoice(WeChatMassVoice voice) {
            this.voice = voice;
        }

        public WeChatMassVideo getVideo() {
            return video;
        }

        public void setVideo(WeChatMassVideo video) {
            this.video = video;
        }
    }

    class WeChatMassGetReq {
        @JsonProperty("msg_id")
        private Long msgId;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
        }
    }

    class WeChatMassSendResp {
        @JsonProperty("msg_id")
        private Long msgId;
        @JsonProperty("msg_data_id")
        private Long msgDataId;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
        }

        public Long getMsgDataId() {
            return msgDataId;
        }

        public void setMsgDataId(Long msgDataId) {
            this.msgDataId = msgDataId;
        }
    }

    class WeChatMassPreviewResp {
        @JsonProperty("msg_id")
        private Long msgId;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
        }
    }

    class WeChatMassGetResp {
        @JsonProperty("msg_id")
        private Long msgId;
        @JsonProperty("msg_status")
        private String msgStatus;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
        }

        public String getMsgStatus() {
            return msgStatus;
        }

        public void setMsgStatus(String msgStatus) {
            this.msgStatus = msgStatus;
        }
    }

    class WeChatMassFilter {
        @JsonProperty("is_to_all")
        private Boolean isToAll;
        @JsonProperty("tag_id")
        private String tagId;

        public Boolean getIsToAll() {
            return isToAll;
        }

        public void setIsToAll(Boolean isToAll) {
            this.isToAll = isToAll;
        }

        public String getTagId() {
            return tagId;
        }

        public void setTagId(String tagId) {
            this.tagId = tagId;
        }
    }

    class WeChatMassText {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    class WeChatMassImage {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMassMpNews {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMassVoice {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMassVideo {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
