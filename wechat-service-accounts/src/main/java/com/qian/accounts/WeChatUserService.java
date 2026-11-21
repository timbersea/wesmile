package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * 公众号服务平台 - 用户管理接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html
 *
 * @author auto-gen
 */
public interface WeChatUserService {

    /**
     * 获取用户基本信息
     *
     * @param openId 用户openid
     * @param lang   返回语言
     * @return 用户信息
     */
    @GET("cgi-bin/user/info")
    WeChatUserInfoResp getUserInfo(@Query("openid") String openId, @Query("lang") String lang);

    /**
     * 批量获取用户基本信息
     *
     * @param req 请求体
     * @return 批量用户信息结果
     */
    @POST("cgi-bin/user/info/batchget")
    WeChatUserBatchInfoResp batchGetUserInfo(@Body WeChatUserBatchInfoReq req);

    /**
     * 获取用户列表
     *
     * @param nextOpenId 起始openid，为空从头拉取
     * @return 用户openid列表
     */
    @GET("cgi-bin/user/get")
    WeChatUserListResp getUserList(@Query("next_openid") String nextOpenId);

    /**
     * 设置用户备注名
     *
     * @param req 请求体
     * @return 基础返回
     */
    @POST("cgi-bin/user/remark/set")
    WeChatBaseResp setUserRemark(@Body WeChatUserRemarkReq req);

    /**
     * 获取标签列表
     *
     * @return 标签列表
     */
    @GET("cgi-bin/tags/get")
    WeChatTagListResp getTagList();

    /**
     * 创建标签
     *
     * @param req 请求体
     * @return 创建标签结果
     */
    @POST("cgi-bin/tags/create")
    WeChatTagCreateResp createTag(@Body WeChatTagCreateReq req);

    /**
     * 修改标签
     *
     * @param req 请求体
     * @return 基础返回
     */
    @POST("cgi-bin/tags/update")
    WeChatBaseResp updateTag(@Body WeChatTagUpdateReq req);

    /**
     * 删除标签
     *
     * @param req 请求体
     * @return 基础返回
     */
    @POST("cgi-bin/tags/delete")
    WeChatBaseResp deleteTag(@Body WeChatTagDeleteReq req);

    /**
     * 给用户打标签
     *
     * @param req 请求体
     * @return 基础返回
     */
    @POST("cgi-bin/tags/members/batchtagging")
    WeChatBaseResp batchTagging(@Body WeChatTagBatchReq req);

    /**
     * 取消用户标签
     *
     * @param req 请求体
     * @return 基础返回
     */
    @POST("cgi-bin/tags/members/batchuntagging")
    WeChatBaseResp batchUnTagging(@Body WeChatTagBatchReq req);

    /**
     * 获取用户身上的标签
     *
     * @param req 请求体
     * @return 用户标签列表
     */
    @POST("cgi-bin/tags/members/getidlist")
    WeChatUserTagIdListResp getUserTagIdList(@Body WeChatUserTagIdReq req);

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

    class WeChatUserInfoResp extends WeChatBaseResp {
        @JsonProperty("subscribe")
        private Integer subscribe;
        @JsonProperty("openid")
        private String openId;
        @JsonProperty("nickname")
        private String nickname;
        @JsonProperty("sex")
        private Integer sex;
        @JsonProperty("province")
        private String province;
        @JsonProperty("city")
        private String city;
        @JsonProperty("country")
        private String country;
        @JsonProperty("headimgurl")
        private String headImgUrl;
        @JsonProperty("subscribe_time")
        private Long subscribeTime;
        @JsonProperty("remark")
        private String remark;
        @JsonProperty("groupid")
        private Integer groupId;
        @JsonProperty("tagid_list")
        private List<Integer> tagIdList;
        @JsonProperty("subscribe_scene")
        private String subscribeScene;
        @JsonProperty("qr_scene")
        private Integer qrScene;
        @JsonProperty("qr_scene_str")
        private String qrSceneStr;

        public Integer getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(Integer subscribe) {
            this.subscribe = subscribe;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public Long getSubscribeTime() {
            return subscribeTime;
        }

        public void setSubscribeTime(Long subscribeTime) {
            this.subscribeTime = subscribeTime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public List<Integer> getTagIdList() {
            return tagIdList;
        }

        public void setTagIdList(List<Integer> tagIdList) {
            this.tagIdList = tagIdList;
        }

        public String getSubscribeScene() {
            return subscribeScene;
        }

        public void setSubscribeScene(String subscribeScene) {
            this.subscribeScene = subscribeScene;
        }

        public Integer getQrScene() {
            return qrScene;
        }

        public void setQrScene(Integer qrScene) {
            this.qrScene = qrScene;
        }

        public String getQrSceneStr() {
            return qrSceneStr;
        }

        public void setQrSceneStr(String qrSceneStr) {
            this.qrSceneStr = qrSceneStr;
        }
    }

    class WeChatUserBatchInfoReq {
        @JsonProperty("user_list")
        private List<WeChatUserBatchItem> userList;

        public List<WeChatUserBatchItem> getUserList() {
            return userList;
        }

        public void setUserList(List<WeChatUserBatchItem> userList) {
            this.userList = userList;
        }
    }

    class WeChatUserBatchItem {
        @JsonProperty("openid")
        private String openId;
        @JsonProperty("lang")
        private String lang;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }

    class WeChatUserBatchInfoResp extends WeChatBaseResp {
        @JsonProperty("user_info_list")
        private List<WeChatUserInfoResp> userInfoList;

        public List<WeChatUserInfoResp> getUserInfoList() {
            return userInfoList;
        }

        public void setUserInfoList(List<WeChatUserInfoResp> userInfoList) {
            this.userInfoList = userInfoList;
        }
    }

    class WeChatUserListResp extends WeChatBaseResp {
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("data")
        private WeChatUserOpenIdData data;
        @JsonProperty("next_openid")
        private String nextOpenId;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public WeChatUserOpenIdData getData() {
            return data;
        }

        public void setData(WeChatUserOpenIdData data) {
            this.data = data;
        }

        public String getNextOpenId() {
            return nextOpenId;
        }

        public void setNextOpenId(String nextOpenId) {
            this.nextOpenId = nextOpenId;
        }
    }

    class WeChatUserOpenIdData {
        @JsonProperty("openid")
        private List<String> openIdList;

        public List<String> getOpenIdList() {
            return openIdList;
        }

        public void setOpenIdList(List<String> openIdList) {
            this.openIdList = openIdList;
        }
    }

    class WeChatUserRemarkReq {
        @JsonProperty("openid")
        private String openId;
        @JsonProperty("remark")
        private String remark;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    class WeChatTag {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;

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
    }

    class WeChatTagListResp extends WeChatBaseResp {
        @JsonProperty("tags")
        private List<WeChatTag> tags;

        public List<WeChatTag> getTags() {
            return tags;
        }

        public void setTags(List<WeChatTag> tags) {
            this.tags = tags;
        }
    }

    class WeChatTagCreateReq {
        @JsonProperty("tag")
        private WeChatTag tag;

        public WeChatTag getTag() {
            return tag;
        }

        public void setTag(WeChatTag tag) {
            this.tag = tag;
        }
    }

    class WeChatTagCreateResp extends WeChatBaseResp {
        @JsonProperty("tag")
        private WeChatTag tag;

        public WeChatTag getTag() {
            return tag;
        }

        public void setTag(WeChatTag tag) {
            this.tag = tag;
        }
    }

    class WeChatTagUpdateReq {
        @JsonProperty("tag")
        private WeChatTag tag;

        public WeChatTag getTag() {
            return tag;
        }

        public void setTag(WeChatTag tag) {
            this.tag = tag;
        }
    }

    class WeChatTagDeleteReq {
        @JsonProperty("tag")
        private WeChatTag tag;

        public WeChatTag getTag() {
            return tag;
        }

        public void setTag(WeChatTag tag) {
            this.tag = tag;
        }
    }

    class WeChatTagBatchReq {
        @JsonProperty("openid_list")
        private List<String> openIdList;
        @JsonProperty("tagid")
        private Integer tagId;

        public List<String> getOpenIdList() {
            return openIdList;
        }

        public void setOpenIdList(List<String> openIdList) {
            this.openIdList = openIdList;
        }

        public Integer getTagId() {
            return tagId;
        }

        public void setTagId(Integer tagId) {
            this.tagId = tagId;
        }
    }

    class WeChatUserTagIdReq {
        @JsonProperty("openid")
        private String openId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }

    class WeChatUserTagIdListResp extends WeChatBaseResp {
        @JsonProperty("tagid_list")
        private List<Integer> tagIdList;

        public List<Integer> getTagIdList() {
            return tagIdList;
        }

        public void setTagIdList(List<Integer> tagIdList) {
            this.tagIdList = tagIdList;
        }
    }
}
