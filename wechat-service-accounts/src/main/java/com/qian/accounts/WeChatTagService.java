package com.qian.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 用户标签管理接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html
 *
 * @author auto-gen
 */
public interface WeChatTagService {

    /**
     * 获取标签列表
     */
    @GET("cgi-bin/tags/get")
    WeChatTagListResp getTagList();

    /**
     * 创建标签
     */
    @POST("cgi-bin/tags/create")
    WeChatTagCreateResp createTag(
            @Body WeChatTagCreateReq req);

    /**
     * 修改标签名称
     */
    @POST("cgi-bin/tags/update")
    WeChatBaseResp updateTag(
            @Body WeChatTagUpdateReq req);

    /**
     * 删除标签
     */
    @POST("cgi-bin/tags/delete")
    WeChatBaseResp deleteTag(
            @Body WeChatTagDeleteReq req);

    /**
     * 获取标签下粉丝列表
     */
    @POST("cgi-bin/user/tag/get")
    WeChatTagUserListResp getTagUserList(
            @Body WeChatTagUserListReq req);

    /**
     * 批量为用户打标签
     */
    @POST("cgi-bin/tags/members/batchtagging")
    WeChatBaseResp batchTagging(
            @Body WeChatTagBatchReq req);

    /**
     * 批量为用户取消标签
     */
    @POST("cgi-bin/tags/members/batchuntagging")
    WeChatBaseResp batchUnTagging(
            @Body WeChatTagBatchReq req);

    /**
     * 获取用户身上的标签列表
     */
    @POST("cgi-bin/tags/getidlist")
    WeChatTagUserOwnedResp getUserTagList(
            @Body WeChatTagUserOwnedReq req);

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

    class WeChatTagItem {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("count")
        private Integer count;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    class WeChatTagListResp extends WeChatBaseResp {
        @JsonProperty("tags")
        private List<WeChatTagItem> tags;

        public List<WeChatTagItem> getTags() {
            return tags;
        }

        public void setTags(List<WeChatTagItem> tags) {
            this.tags = tags;
        }
    }

    class WeChatTagCreateReq {
        @JsonProperty("tag")
        private WeChatTagItem tag;

        public WeChatTagItem getTag() {
            return tag;
        }

        public void setTag(WeChatTagItem tag) {
            this.tag = tag;
        }
    }

    class WeChatTagCreateResp extends WeChatBaseResp {
        @JsonProperty("tag")
        private WeChatTagItem tag;

        public WeChatTagItem getTag() {
            return tag;
        }

        public void setTag(WeChatTagItem tag) {
            this.tag = tag;
        }
    }

    class WeChatTagUpdateReq {
        @JsonProperty("tag")
        private WeChatTagItem tag;

        public WeChatTagItem getTag() {
            return tag;
        }

        public void setTag(WeChatTagItem tag) {
            this.tag = tag;
        }
    }

    class WeChatTagDeleteReq {
        @JsonProperty("tag")
        private WeChatTagItem tag;

        public WeChatTagItem getTag() {
            return tag;
        }

        public void setTag(WeChatTagItem tag) {
            this.tag = tag;
        }
    }

    class WeChatTagUserListReq {
        @JsonProperty("tagid")
        private Integer tagId;
        @JsonProperty("next_openid")
        private String nextOpenid;

        public Integer getTagId() {
            return tagId;
        }

        public void setTagId(Integer tagId) {
            this.tagId = tagId;
        }

        public String getNextOpenid() {
            return nextOpenid;
        }

        public void setNextOpenid(String nextOpenid) {
            this.nextOpenid = nextOpenid;
        }
    }

    class WeChatTagUserListResp extends WeChatBaseResp {
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("data")
        private WeChatBlacklistOpenidData data;
        @JsonProperty("next_openid")
        private String nextOpenid;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public WeChatBlacklistOpenidData getData() {
            return data;
        }

        public void setData(WeChatBlacklistOpenidData data) {
            this.data = data;
        }

        public String getNextOpenid() {
            return nextOpenid;
        }

        public void setNextOpenid(String nextOpenid) {
            this.nextOpenid = nextOpenid;
        }
    }

    class WeChatTagBatchReq {
        @JsonProperty("openid_list")
        private List<String> openidList;
        @JsonProperty("tagid")
        private Integer tagId;

        public List<String> getOpenidList() {
            return openidList;
        }

        public void setOpenidList(List<String> openidList) {
            this.openidList = openidList;
        }

        public Integer getTagId() {
            return tagId;
        }

        public void setTagId(Integer tagId) {
            this.tagId = tagId;
        }
    }

    class WeChatTagUserOwnedReq {
        @JsonProperty("openid")
        private String openid;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }

    class WeChatTagUserOwnedResp extends WeChatBaseResp {
        @JsonProperty("tagid_list")
        private List<Integer> tagidList;

        public List<Integer> getTagidList() {
            return tagidList;
        }

        public void setTagidList(List<Integer> tagidList) {
            this.tagidList = tagidList;
        }
    }

    class WeChatBlacklistOpenidData {
        @JsonProperty("openid")
        private List<String> openid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }
    }
}
