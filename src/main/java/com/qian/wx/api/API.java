package com.qian.wx.api;


import com.qian.wx.annotation.JsonBody;
import com.qian.wx.annotation.ParamName;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.param.UserAnalyze;
import com.qian.wx.model.result.Getusersummary;
import com.qian.wx.model.result.UserInfo;
import com.qian.wx.model.result.UserList;

public interface API {

    @RelativePath("/cgi-bin/user/info")
    UserInfo userInfo(@ParamName("openid") String openid, @ParamName("lang") String lang);

    @RelativePath("/cgi-bin/user/get")
    UserList userList(@ParamName("next_openid") String openid);


    @RelativePath("/datacube/getusersummary")
    Getusersummary getusersummary(@JsonBody UserAnalyze userAnalyze);

    Getusersummary aa(@JsonBody UserAnalyze userAnalyze);
}
