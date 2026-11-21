package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 群发消息接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Batch_Sends_and_Originality_Checks.html
 *
 * @author auto-gen
 */
public interface WeChatMassMessageService {

    /**
     * 根据标签进行群发
     *
     * @param req 群发请求
     * @return 群发结果
     */
    @POST("cgi-bin/message/mass/sendall")
    WeChatMassSendResp massSendAll(
            @Body WeChatMassSendAllReq req);

    /**
     * 根据OpenID列表群发
     *
     * @param req 群发请求
     * @return 群发结果
     */
    @POST("cgi-bin/message/mass/send")
    WeChatMassSendResp massSend(
            @Body WeChatMassSendReq req);

    /**
     * 删除群发
     *
     * @param req 删除请求
     * @return 基础返回
     */
    @POST("cgi-bin/message/mass/delete")
    WeChatBaseResp massDelete(
            @Body WeChatMassDeleteReq req);

    /**
     * 预览群发消息
     *
     * @param req 预览请求
     * @return 预览结果
     */
    @POST("cgi-bin/message/mass/preview")
    WeChatMassPreviewResp massPreview(
            @Body WeChatMassPreviewReq req);

    /**
     * 查询群发消息发送状态
     *
     * @param req 查询请求
     * @return 状态结果
     */
    @POST("cgi-bin/message/mass/get")
    WeChatMassGetResp massGet(
            @Body WeChatMassGetReq req);

    /**
     * 获取群发速度
     *
     * @return 速度结果
     */
    @GET("cgi-bin/message/mass/speed/get")
    WeChatMassSpeedGetResp massSpeedGet();

    /**
     * 设置群发速度
     *
     * @param req 设置速度请求
     * @return 基础返回
     */
    @POST("cgi-bin/message/mass/speed/set")
    WeChatBaseResp massSpeedSet(
            @Body WeChatMassSpeedSetReq req);

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

    class WeChatMassFilter {
        @JsonProperty("is_to_all")
        private Boolean isToAll;
        @JsonProperty("tag_id")
        private Long tagId;

        public Boolean getIsToAll() {
            return isToAll;
        }

        public void setIsToAll(Boolean isToAll) {
            this.isToAll = isToAll;
        }

        public Long getTagId() {
            return tagId;
        }

        public void setTagId(Long tagId) {
            this.tagId = tagId;
        }
    }

    class WeChatMassArticle {
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

    class WeChatMassText {
        @JsonProperty("content")
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

    class WeChatMassSendAllReq {
        @JsonProperty("filter")
        private WeChatMassFilter filter;
        @JsonProperty("mpnews")
        private WeChatMassMpNews mpNews;
        @JsonProperty("text")
        private WeChatMassText text;
        @JsonProperty("image")
        private WeChatMassImage image;
        @JsonProperty("voice")
        private WeChatMassVoice voice;
        @JsonProperty("video")
        private WeChatMassVideo video;
        @JsonProperty("msgtype")
        private String msgType;
        @JsonProperty("send_ignore_reprint")
        private Integer sendIgnoreReprint;

        public WeChatMassFilter getFilter() {
            return filter;
        }

        public void setFilter(WeChatMassFilter filter) {
            this.filter = filter;
        }

        public WeChatMassMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatMassMpNews mpNews) {
            this.mpNews = mpNews;
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

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
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
        @JsonProperty("mpnews")
        private WeChatMassMpNews mpNews;
        @JsonProperty("text")
        private WeChatMassText text;
        @JsonProperty("image")
        private WeChatMassImage image;
        @JsonProperty("voice")
        private WeChatMassVoice voice;
        @JsonProperty("video")
        private WeChatMassVideo video;
        @JsonProperty("msgtype")
        private String msgType;
        @JsonProperty("send_ignore_reprint")
        private Integer sendIgnoreReprint;

        public List<String> getToUser() {
            return toUser;
        }

        public void setToUser(List<String> toUser) {
            this.toUser = toUser;
        }

        public WeChatMassMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatMassMpNews mpNews) {
            this.mpNews = mpNews;
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

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public Integer getSendIgnoreReprint() {
            return sendIgnoreReprint;
        }

        public void setSendIgnoreReprint(Integer sendIgnoreReprint) {
            this.sendIgnoreReprint = sendIgnoreReprint;
        }
    }

    class WeChatMassSendResp extends WeChatBaseResp {
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
        @JsonProperty("mpnews")
        private WeChatMassMpNews mpNews;
        @JsonProperty("text")
        private WeChatMassText text;
        @JsonProperty("image")
        private WeChatMassImage image;
        @JsonProperty("voice")
        private WeChatMassVoice voice;
        @JsonProperty("video")
        private WeChatMassVideo video;
        @JsonProperty("msgtype")
        private String msgType;

        public String getToUser() {
            return toUser;
        }

        public void setToUser(String toUser) {
            this.toUser = toUser;
        }

        public WeChatMassMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatMassMpNews mpNews) {
            this.mpNews = mpNews;
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

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }
    }

    class WeChatMassPreviewResp extends WeChatBaseResp {
        @JsonProperty("msg_id")
        private Long msgId;

        public Long getMsgId() {
            return msgId;
        }

        public void setMsgId(Long msgId) {
            this.msgId = msgId;
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

    class WeChatMassGetResp extends WeChatBaseResp {
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

    class WeChatMassSpeedGetResp extends WeChatBaseResp {
        @JsonProperty("speed")
        private Integer speed;

        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }
    }

    class WeChatMassSpeedSetReq {
        @JsonProperty("speed")
        private Integer speed;

        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }
    }
}
