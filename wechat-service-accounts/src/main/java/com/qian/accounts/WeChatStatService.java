package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 数据分析接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Analytics/Analytics_API.html
 *
 * @author auto-gen
 */
public interface WeChatStatService {

    /**
     * 获取用户增减数据
     */
    @POST("cgi-bin/user/getsummary")
    WeChatStatUserSummaryResp getUserSummary(
            @Body WeChatStatDateReq req);

    /**
     * 获取累计用户数据
     */
    @POST("cgi-bin/user/getcumulate")
    WeChatStatUserCumulateResp getUserCumulate(
            @Body WeChatStatDateReq req);

    /**
     * 获取图文群发每日数据
     */
    @POST("cgi-bin/message/getarticlesummary")
    WeChatStatArticleSummaryResp getArticleSummary(
            @Body WeChatStatDateReq req);

    /**
     * 获取图文群发总数据
     */
    @POST("cgi-bin/message/getarticletotal")
    WeChatStatArticleTotalResp getArticleTotal(
            @Body WeChatStatDateReq req);

    /**
     * 获取图文阅读分时数据
     */
    @POST("cgi-bin/message/getread")
    WeChatStatReadResp getRead(
            @Body WeChatStatDateReq req);

    /**
     * 获取图文分享分时数据
     */
    @POST("cgi-bin/message/getreadshare")
    WeChatStatReadShareResp getReadShare(
            @Body WeChatStatDateReq req);

    /**
     * 获取消息发送概况数据
     */
    @POST("cgi-bin/message/getupstreammsg")
    WeChatStatUpstreamMsgResp getUpstreamMsg(
            @Body WeChatStatDateReq req);

    /**
     * 获取消息分送分时数据
     */
    @POST("cgi-bin/message/getupstreammsgdist")
    WeChatStatUpstreamMsgDistResp getUpstreamMsgDist(
            @Body WeChatStatDateReq req);

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

    class WeChatStatDateReq {
        @JsonProperty("begin_date")
        private String beginDate;
        @JsonProperty("end_date")
        private String endDate;

        public String getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
    }

    class WeChatStatUserSummaryItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("user_source")
        private Integer userSource;
        @JsonProperty("new_user")
        private Integer newUser;
        @JsonProperty("cancel_user")
        private Integer cancelUser;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public Integer getUserSource() {
            return userSource;
        }

        public void setUserSource(Integer userSource) {
            this.userSource = userSource;
        }

        public Integer getNewUser() {
            return newUser;
        }

        public void setNewUser(Integer newUser) {
            this.newUser = newUser;
        }

        public Integer getCancelUser() {
            return cancelUser;
        }

        public void setCancelUser(Integer cancelUser) {
            this.cancelUser = cancelUser;
        }
    }

    class WeChatStatUserSummaryResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatUserSummaryItem> list;

        public List<WeChatStatUserSummaryItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatUserSummaryItem> list) {
            this.list = list;
        }
    }

    class WeChatStatUserCumulateItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("cumulate_user")
        private Integer cumulateUser;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public Integer getCumulateUser() {
            return cumulateUser;
        }

        public void setCumulateUser(Integer cumulateUser) {
            this.cumulateUser = cumulateUser;
        }
    }

    class WeChatStatUserCumulateResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatUserCumulateItem> list;

        public List<WeChatStatUserCumulateItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatUserCumulateItem> list) {
            this.list = list;
        }
    }

    class WeChatStatArticleSummaryItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("msgid")
        private String msgId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("int_page_read_user")
        private Integer intPageReadUser;
        @JsonProperty("int_page_read_count")
        private Integer intPageReadCount;
        @JsonProperty("ori_page_read_user")
        private Integer oriPageReadUser;
        @JsonProperty("ori_page_read_count")
        private Integer oriPageReadCount;
        @JsonProperty("share_user")
        private Integer shareUser;
        @JsonProperty("share_count")
        private Integer shareCount;
        @JsonProperty("add_to_fav_user")
        private Integer addToFavUser;
        @JsonProperty("add_to_fav_count")
        private Integer addToFavCount;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getIntPageReadUser() {
            return intPageReadUser;
        }

        public void setIntPageReadUser(Integer intPageReadUser) {
            this.intPageReadUser = intPageReadUser;
        }

        public Integer getIntPageReadCount() {
            return intPageReadCount;
        }

        public void setIntPageReadCount(Integer intPageReadCount) {
            this.intPageReadCount = intPageReadCount;
        }

        public Integer getOriPageReadUser() {
            return oriPageReadUser;
        }

        public void setOriPageReadUser(Integer oriPageReadUser) {
            this.oriPageReadUser = oriPageReadUser;
        }

        public Integer getOriPageReadCount() {
            return oriPageReadCount;
        }

        public void setOriPageReadCount(Integer oriPageReadCount) {
            this.oriPageReadCount = oriPageReadCount;
        }

        public Integer getShareUser() {
            return shareUser;
        }

        public void setShareUser(Integer shareUser) {
            this.shareUser = shareUser;
        }

        public Integer getShareCount() {
            return shareCount;
        }

        public void setShareCount(Integer shareCount) {
            this.shareCount = shareCount;
        }

        public Integer getAddToFavUser() {
            return addToFavUser;
        }

        public void setAddToFavUser(Integer addToFavUser) {
            this.addToFavUser = addToFavUser;
        }

        public Integer getAddToFavCount() {
            return addToFavCount;
        }

        public void setAddToFavCount(Integer addToFavCount) {
            this.addToFavCount = addToFavCount;
        }
    }

    class WeChatStatArticleSummaryResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatArticleSummaryItem> list;

        public List<WeChatStatArticleSummaryItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatArticleSummaryItem> list) {
            this.list = list;
        }
    }

    class WeChatStatArticleTotalDetail {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("int_page_read_user")
        private Integer intPageReadUser;
        @JsonProperty("int_page_read_count")
        private Integer intPageReadCount;
        @JsonProperty("ori_page_read_user")
        private Integer oriPageReadUser;
        @JsonProperty("ori_page_read_count")
        private Integer oriPageReadCount;
        @JsonProperty("share_user")
        private Integer shareUser;
        @JsonProperty("share_count")
        private Integer shareCount;
        @JsonProperty("add_to_fav_user")
        private Integer addToFavUser;
        @JsonProperty("add_to_fav_count")
        private Integer addToFavCount;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public Integer getIntPageReadUser() {
            return intPageReadUser;
        }

        public void setIntPageReadUser(Integer intPageReadUser) {
            this.intPageReadUser = intPageReadUser;
        }

        public Integer getIntPageReadCount() {
            return intPageReadCount;
        }

        public void setIntPageReadCount(Integer intPageReadCount) {
            this.intPageReadCount = intPageReadCount;
        }

        public Integer getOriPageReadUser() {
            return oriPageReadUser;
        }

        public void setOriPageReadUser(Integer oriPageReadUser) {
            this.oriPageReadUser = oriPageReadUser;
        }

        public Integer getOriPageReadCount() {
            return oriPageReadCount;
        }

        public void setOriPageReadCount(Integer oriPageReadCount) {
            this.oriPageReadCount = oriPageReadCount;
        }

        public Integer getShareUser() {
            return shareUser;
        }

        public void setShareUser(Integer shareUser) {
            this.shareUser = shareUser;
        }

        public Integer getShareCount() {
            return shareCount;
        }

        public void setShareCount(Integer shareCount) {
            this.shareCount = shareCount;
        }

        public Integer getAddToFavUser() {
            return addToFavUser;
        }

        public void setAddToFavUser(Integer addToFavUser) {
            this.addToFavUser = addToFavUser;
        }

        public Integer getAddToFavCount() {
            return addToFavCount;
        }

        public void setAddToFavCount(Integer addToFavCount) {
            this.addToFavCount = addToFavCount;
        }
    }

    class WeChatStatArticleTotalItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("msgid")
        private String msgId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("details")
        private List<WeChatStatArticleTotalDetail> details;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<WeChatStatArticleTotalDetail> getDetails() {
            return details;
        }

        public void setDetails(List<WeChatStatArticleTotalDetail> details) {
            this.details = details;
        }
    }

    class WeChatStatArticleTotalResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatArticleTotalItem> list;

        public List<WeChatStatArticleTotalItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatArticleTotalItem> list) {
            this.list = list;
        }
    }

    class WeChatStatReadItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("ref_hour")
        private Integer refHour;
        @JsonProperty("int_page_read_user")
        private Integer intPageReadUser;
        @JsonProperty("int_page_read_count")
        private Integer intPageReadCount;
        @JsonProperty("ori_page_read_user")
        private Integer oriPageReadUser;
        @JsonProperty("ori_page_read_count")
        private Integer oriPageReadCount;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public Integer getRefHour() {
            return refHour;
        }

        public void setRefHour(Integer refHour) {
            this.refHour = refHour;
        }

        public Integer getIntPageReadUser() {
            return intPageReadUser;
        }

        public void setIntPageReadUser(Integer intPageReadUser) {
            this.intPageReadUser = intPageReadUser;
        }

        public Integer getIntPageReadCount() {
            return intPageReadCount;
        }

        public void setIntPageReadCount(Integer intPageReadCount) {
            this.intPageReadCount = intPageReadCount;
        }

        public Integer getOriPageReadUser() {
            return oriPageReadUser;
        }

        public void setOriPageReadUser(Integer oriPageReadUser) {
            this.oriPageReadUser = oriPageReadUser;
        }

        public Integer getOriPageReadCount() {
            return oriPageReadCount;
        }

        public void setOriPageReadCount(Integer oriPageReadCount) {
            this.oriPageReadCount = oriPageReadCount;
        }
    }

    class WeChatStatReadResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatReadItem> list;

        public List<WeChatStatReadItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatReadItem> list) {
            this.list = list;
        }
    }

    class WeChatStatReadShareItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("ref_hour")
        private Integer refHour;
        @JsonProperty("share_scene")
        private Integer shareScene;
        @JsonProperty("share_count")
        private Integer shareCount;
        @JsonProperty("share_user")
        private Integer shareUser;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public Integer getRefHour() {
            return refHour;
        }

        public void setRefHour(Integer refHour) {
            this.refHour = refHour;
        }

        public Integer getShareScene() {
            return shareScene;
        }

        public void setShareScene(Integer shareScene) {
            this.shareScene = shareScene;
        }

        public Integer getShareCount() {
            return shareCount;
        }

        public void setShareCount(Integer shareCount) {
            this.shareCount = shareCount;
        }

        public Integer getShareUser() {
            return shareUser;
        }

        public void setShareUser(Integer shareUser) {
            this.shareUser = shareUser;
        }
    }

    class WeChatStatReadShareResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatReadShareItem> list;

        public List<WeChatStatReadShareItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatReadShareItem> list) {
            this.list = list;
        }
    }

    class WeChatStatUpstreamMsgItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("msg_type")
        private Integer msgType;
        @JsonProperty("msg_user")
        private Integer msgUser;
        @JsonProperty("msg_count")
        private Integer msgCount;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public Integer getMsgType() {
            return msgType;
        }

        public void setMsgType(Integer msgType) {
            this.msgType = msgType;
        }

        public Integer getMsgUser() {
            return msgUser;
        }

        public void setMsgUser(Integer msgUser) {
            this.msgUser = msgUser;
        }

        public Integer getMsgCount() {
            return msgCount;
        }

        public void setMsgCount(Integer msgCount) {
            this.msgCount = msgCount;
        }
    }

    class WeChatStatUpstreamMsgResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatUpstreamMsgItem> list;

        public List<WeChatStatUpstreamMsgItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatUpstreamMsgItem> list) {
            this.list = list;
        }
    }

    class WeChatStatUpstreamMsgDistItem {
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("ref_hour")
        private Integer refHour;
        @JsonProperty("msg_type")
        private Integer msgType;
        @JsonProperty("msg_user")
        private Integer msgUser;
        @JsonProperty("msg_count")
        private Integer msgCount;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public Integer getRefHour() {
            return refHour;
        }

        public void setRefHour(Integer refHour) {
            this.refHour = refHour;
        }

        public Integer getMsgType() {
            return msgType;
        }

        public void setMsgType(Integer msgType) {
            this.msgType = msgType;
        }

        public Integer getMsgUser() {
            return msgUser;
        }

        public void setMsgUser(Integer msgUser) {
            this.msgUser = msgUser;
        }

        public Integer getMsgCount() {
            return msgCount;
        }

        public void setMsgCount(Integer msgCount) {
            this.msgCount = msgCount;
        }
    }

    class WeChatStatUpstreamMsgDistResp extends WeChatBaseResp {
        @JsonProperty("list")
        private List<WeChatStatUpstreamMsgDistItem> list;

        public List<WeChatStatUpstreamMsgDistItem> getList() {
            return list;
        }

        public void setList(List<WeChatStatUpstreamMsgDistItem> list) {
            this.list = list;
        }
    }
}
