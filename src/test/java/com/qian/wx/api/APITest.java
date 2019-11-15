package com.qian.wx.api;

import com.alibaba.fastjson.JSON;
import com.qian.wx.model.param.UserAnalyze;
import com.qian.wx.model.result.Getusersummary;
import com.qian.wx.model.result.UserInfo;
import com.qian.wx.model.result.UserList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APITest {
    private static final Logger log = LoggerFactory.getLogger(APITest.class);
    API instance;
    Object o;
    private String appid = "yourAppID";
    private String appsecret = "yourAPPSecret";
    private String domain = "https://api.weixin.qq.com";

    @Before
    public void setUp() throws Exception {
        instance = ApiUtil.getInstance(domain, appid, appsecret, API.class);
    }

    @After
    public void tearDown() throws Exception {
        log.info(JSON.toJSONString(o));
    }

    @Test
    public void testUserList() {
        UserList userList = instance.userList(null);

        o = userList;
    }

    @Test
    public void userInfo() {
        UserInfo userInfo = instance.userInfo("of8f-w4CtJlC845gCNSll4Mlsg9s", "zh_CN");

        o = userInfo;
    }

    @Test
    public void test() {
        UserAnalyze userAnalyze = new UserAnalyze();
        userAnalyze.setBegin_date("2014-12-02");
        userAnalyze.setEnd_date("2014-12-07");
        Getusersummary getusersummary = instance.getusersummary(userAnalyze);
        o = getusersummary;
    }
}