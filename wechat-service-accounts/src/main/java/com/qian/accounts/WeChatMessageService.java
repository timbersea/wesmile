package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 客服消息接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Service_Center_messages.html
 *
 * @author auto-gen
 */
public interface WeChatMessageService {

    /**
     * 发送客服消息
     *
     * @param req 消息请求体
     * @return 基础返回
     */
    @POST("cgi-bin/message/custom/send")
    WeChatBaseResp sendCustomMessage(
            @Body WeChatCustomMessageReq req);

    /**
     * 获取客服列表
     *
     * @return 客服列表
     */
    @GET("cgi-bin/customservice/getkflist")
    WeChatKfListResp getKfList();

    /**
     * 获取在线客服列表
     *
     * @return 在线客服列表
     */
    @GET("cgi-bin/customservice/getonlinekflist")
    WeChatOnlineKfListResp getOnlineKfList();

    /**
     * 添加客服账号
     *
     * @param req 客服账号请求
     * @return 基础返回
     */
    @POST("cgi-bin/customservice/kfaccount/add")
    WeChatBaseResp addKfAccount(
            @Body WeChatKfAccountReq req);

    /**
     * 修改客服账号
     *
     * @param req 客服账号请求
     * @return 基础返回
     */
    @POST("cgi-bin/customservice/kfaccount/update")
    WeChatBaseResp updateKfAccount(
            @Body WeChatKfAccountReq req);

    /**
     * 删除客服账号
     *
     * @param req 客服账号请求
     * @return 基础返回
     */
    @POST("cgi-bin/customservice/kfaccount/del")
    WeChatBaseResp delKfAccount(
            @Body WeChatKfAccountReq req);

    /**
     * 设置客服头像
     *
     * @return 基础返回
     */
    @POST("cgi-bin/customservice/kfaccount/uploadheadimg")
    WeChatBaseResp uploadKfHeadImg();

    /**
     * 创建客服会话
     *
     * @param req 会话请求
     * @return 基础返回
     */
    @POST("cgi-bin/customservice/kfsession/create")
    WeChatBaseResp createKfSession(
            @Body WeChatKfSessionReq req);

    /**
     * 关闭客服会话
     *
     * @param req 会话请求
     * @return 基础返回
     */
    @POST("cgi-bin/customservice/kfsession/close")
    WeChatBaseResp closeKfSession(
            @Body WeChatKfSessionReq req);

    /**
     * 获取用户当前会话
     *
     * @param req openid
     * @return 会话信息
     */
    @POST("cgi-bin/customservice/kfsession/getsession")
    WeChatKfSessionResp getKfSession(
            @Body WeChatKfSessionGetReq req);

    /**
     * 获取客服会话列表
     *
     * @param req kf账号
     * @return 会话列表
     */
    @POST("cgi-bin/customservice/kfsession/getsessionlist")
    WeChatKfSessionListResp getKfSessionList(
            @Body WeChatKfSessionListReq req);

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

    class WeChatCustomMessageReq {
        @JsonProperty("touser")
        private String toUser;
        @JsonProperty("msgtype")
        private String msgType;
        @JsonProperty("text")
        private WeChatMsgText text;
        @JsonProperty("image")
        private WeChatMsgImage image;
        @JsonProperty("voice")
        private WeChatMsgVoice voice;
        @JsonProperty("video")
        private WeChatMsgVideo video;
        @JsonProperty("music")
        private WeChatMsgMusic music;
        @JsonProperty("news")
        private WeChatMsgNews news;
        @JsonProperty("mpnews")
        private WeChatMsgMpNews mpNews;
        @JsonProperty("wxcard")
        private WeChatMsgWxCard wxCard;
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

        public WeChatMsgText getText() {
            return text;
        }

        public void setText(WeChatMsgText text) {
            this.text = text;
        }

        public WeChatMsgImage getImage() {
            return image;
        }

        public void setImage(WeChatMsgImage image) {
            this.image = image;
        }

        public WeChatMsgVoice getVoice() {
            return voice;
        }

        public void setVoice(WeChatMsgVoice voice) {
            this.voice = voice;
        }

        public WeChatMsgVideo getVideo() {
            return video;
        }

        public void setVideo(WeChatMsgVideo video) {
            this.video = video;
        }

        public WeChatMsgMusic getMusic() {
            return music;
        }

        public void setMusic(WeChatMsgMusic music) {
            this.music = music;
        }

        public WeChatMsgNews getNews() {
            return news;
        }

        public void setNews(WeChatMsgNews news) {
            this.news = news;
        }

        public WeChatMsgMpNews getMpNews() {
            return mpNews;
        }

        public void setMpNews(WeChatMsgMpNews mpNews) {
            this.mpNews = mpNews;
        }

        public WeChatMsgWxCard getWxCard() {
            return wxCard;
        }

        public void setWxCard(WeChatMsgWxCard wxCard) {
            this.wxCard = wxCard;
        }

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }
    }

    class WeChatMsgText {
        @JsonProperty("content")
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    class WeChatMsgImage {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMsgVoice {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMsgVideo {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
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

    class WeChatMsgMusic {
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;
        @JsonProperty("musicurl")
        private String musicUrl;
        @JsonProperty("hqmusicurl")
        private String hqMusicUrl;
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;

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
    }

    class WeChatMsgNews {
        @JsonProperty("articles")
        private List<WeChatMsgArticle> articles;

        public List<WeChatMsgArticle> getArticles() {
            return articles;
        }

        public void setArticles(List<WeChatMsgArticle> articles) {
            this.articles = articles;
        }
    }

    class WeChatMsgArticle {
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;
        @JsonProperty("url")
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

    class WeChatMsgMpNews {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    class WeChatMsgWxCard {
        @JsonProperty("card_id")
        private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    class WeChatKfItem {
        @JsonProperty("kf_account")
        private String kfAccount;
        @JsonProperty("kf_nick")
        private String kfNick;
        @JsonProperty("kf_id")
        private String kfId;
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

        public String getKfId() {
            return kfId;
        }

        public void setKfId(String kfId) {
            this.kfId = kfId;
        }

        public String getKfHeadImgUrl() {
            return kfHeadImgUrl;
        }

        public void setKfHeadImgUrl(String kfHeadImgUrl) {
            this.kfHeadImgUrl = kfHeadImgUrl;
        }
    }

    class WeChatKfListResp extends WeChatBaseResp {
        @JsonProperty("kf_list")
        private List<WeChatKfItem> kfList;

        public List<WeChatKfItem> getKfList() {
            return kfList;
        }

        public void setKfList(List<WeChatKfItem> kfList) {
            this.kfList = kfList;
        }
    }

    class WeChatOnlineKfItem {
        @JsonProperty("kf_account")
        private String kfAccount;
        @JsonProperty("status")
        private Integer status;
        @JsonProperty("accepted_case")
        private Integer acceptedCase;

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

        public Integer getAcceptedCase() {
            return acceptedCase;
        }

        public void setAcceptedCase(Integer acceptedCase) {
            this.acceptedCase = acceptedCase;
        }
    }

    class WeChatOnlineKfListResp extends WeChatBaseResp {
        @JsonProperty("kf_online_list")
        private List<WeChatOnlineKfItem> kfOnlineList;

        public List<WeChatOnlineKfItem> getKfOnlineList() {
            return kfOnlineList;
        }

        public void setKfOnlineList(List<WeChatOnlineKfItem> kfOnlineList) {
            this.kfOnlineList = kfOnlineList;
        }
    }

    class WeChatKfAccountReq {
        @JsonProperty("kf_account")
        private String kfAccount;
        @JsonProperty("nickname")
        private String nickname;
        @JsonProperty("password")
        private String password;

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    class WeChatKfSessionReq {
        @JsonProperty("openid")
        private String openId;
        @JsonProperty("kf_account")
        private String kfAccount;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }
    }

    class WeChatKfSessionGetReq {
        @JsonProperty("openid")
        private String openId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }

    class WeChatKfSessionResp extends WeChatBaseResp {
        @JsonProperty("kf_account")
        private String kfAccount;
        @JsonProperty("createtime")
        private Long createTime;

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
    }

    class WeChatKfSessionListReq {
        @JsonProperty("kf_account")
        private String kfAccount;

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }
    }

    class WeChatKfSessionListResp extends WeChatBaseResp {
        @JsonProperty("sessionlist")
        private List<WeChatKfSessionItem> sessionList;

        public List<WeChatKfSessionItem> getSessionList() {
            return sessionList;
        }

        public void setSessionList(List<WeChatKfSessionItem> sessionList) {
            this.sessionList = sessionList;
        }
    }

    class WeChatKfSessionItem {
        @JsonProperty("openid")
        private String openId;
        @JsonProperty("createtime")
        private Long createTime;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }
    }
}
