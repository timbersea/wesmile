package com.qian.wx.model.result;

public class ManageBlacklistReuslt {

    /**
     * total : 23000
     * count : 10000
     * data : {"     openid":["OPENID1","OPENID2","OPENID10000"]}
     * next_openid : OPENID10000
     */

    private int total;
    private int count;
    private DataBean data;
    private String next_openid;

    public static class DataBean {
        private java.util.List<String> openid;
    }
}
