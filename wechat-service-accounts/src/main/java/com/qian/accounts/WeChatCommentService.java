package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 图文评论管理接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/Comments_management/Image_Comments_Management_Interface.html
 *
 * @author auto-gen
 */
public interface WeChatCommentService {

    /**
     * 打开/关闭指定图文的评论
     *
     * @param req 图文素材media_id + 是否开启评论
     * @return 基础返回
     */
    @POST("cgi-bin/comment/open")
    WeChatBaseResp openComment(
            @Body WeChatCommentOpenReq req);

    /**
     * 获取图文评论列表
     *
     * @param req media_id + index + count + 类型
     * @return 评论列表
     */
    @POST("cgi-bin/comment/list")
    WeChatCommentListResp getCommentList(
            @Body WeChatCommentListReq req);

    /**
     * 删除评论
     *
     * @param req media_id + comment_id
     * @return 基础返回
     */
    @POST("cgi-bin/comment/delete")
    WeChatBaseResp deleteComment(
            @Body WeChatCommentOperateReq req);

    /**
     * 置顶评论
     *
     * @param req media_id + comment_id
     * @return 基础返回
     */
    @POST("cgi-bin/comment/top")
    WeChatBaseResp topComment(
            @Body WeChatCommentOperateReq req);

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

    class WeChatCommentOpenReq {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("open")
        private Integer open; // 0关闭，1开启

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public Integer getOpen() {
            return open;
        }

        public void setOpen(Integer open) {
            this.open = open;
        }
    }

    class WeChatCommentListReq {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("type")
        private Integer type; // 0普通评论，1精选评论

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

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }

    class WeChatCommentItem {
        @JsonProperty("comment_id")
        private String commentId;
        @JsonProperty("openid")
        private String openid;
        @JsonProperty("content")
        private String content;
        @JsonProperty("create_time")
        private Long createTime;
        @JsonProperty("like_count")
        private Integer likeCount;
        @JsonProperty("is_top")
        private Integer isTop;

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
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

        public Integer getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(Integer likeCount) {
            this.likeCount = likeCount;
        }

        public Integer getIsTop() {
            return isTop;
        }

        public void setIsTop(Integer isTop) {
            this.isTop = isTop;
        }
    }

    class WeChatCommentListResp extends WeChatBaseResp {
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("comment")
        private List<WeChatCommentItem> comment;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<WeChatCommentItem> getComment() {
            return comment;
        }

        public void setComment(List<WeChatCommentItem> comment) {
            this.comment = comment;
        }
    }

    class WeChatCommentOperateReq {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("comment_id")
        private String commentId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }
    }
}

