package com.qian.accounts;


import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 公众号服务平台 - 黑名单管理接口
 * 官方文档地址：https://developers.weixin.qq.com/doc/offiaccount/User_Management/Manage_blacklist.html
 *
 * @author auto-gen
 */
public interface WeChatBlacklistService {

    /**
     * 获取黑名单列表
     */
    @POST("cgi-bin/tags/members/getblacklist")
    WeChatBlacklistGetResp getBlackList(
            @Body WeChatBlacklistGetReq req);

    /**
     * 拉黑用户
     */
    @POST("cgi-bin/tags/members/batchblacklist")
    WeChatBaseResp batchBlackList(
            @Body WeChatBlacklistBatchReq req);

    /**
     * 取消拉黑用户
     */
    @POST("cgi-bin/tags/members/batchunblacklist")
    WeChatBaseResp batchUnBlackList(
            @Body WeChatBlacklistBatchReq req);

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

    class WeChatBlacklistGetReq {
        @JsonProperty("begin_openid")
        private String beginOpenid;

        public String getBeginOpenid() {
            return beginOpenid;
        }

        public void setBeginOpenid(String beginOpenid) {
            this.beginOpenid = beginOpenid;
        }
    }

    class WeChatBlacklistGetResp extends WeChatBaseResp {
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("data")
        private WeChatBlacklistOpenidData data;
        @JsonProperty("next_openid")
        private String nextOpenid;

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

    class WeChatBlacklistBatchReq {
        @JsonProperty("openid_list")
        private List<String> openidList;

        public List<String> getOpenidList() {
            return openidList;
        }

        public void setOpenidList(List<String> openidList) {
            this.openidList = openidList;
        }
    }
}

