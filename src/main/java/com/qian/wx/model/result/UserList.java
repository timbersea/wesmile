package com.qian.wx.model.result;

import java.util.List;

public class UserList {

    /**
     * total : 8
     * count : 8
     * data : {"openid":["of8f-w4CtJlC845gCNSll4Mlsg9s","of8f-w5yugEJy81bWHk_OcOaf2W0","of8f-w-TjJ2NDNDzbYTInXtCb6GU","of8f-w1Dyzc9I54jvcnX6RxPQ_C0","of8f-w5qMhqU0Xm7BzDGHFhA71p0","of8f-w0uaFHzjfy_11hH4priQXgU","of8f-w35KfeoX5QUGdBot9dFFr88","of8f-w9SDCfpWNkNcqmBboxk9Vys"]}
     * next_openid : of8f-w9SDCfpWNkNcqmBboxk9Vys
     */

    private int total;
    private int count;
    private DataBean data;
    private String next_openid;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public static class DataBean {
        private List<String> openid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }
    }
}
