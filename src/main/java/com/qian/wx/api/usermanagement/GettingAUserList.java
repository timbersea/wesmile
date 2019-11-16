package com.qian.wx.api.usermanagement;

import com.qian.wx.annotation.ParamName;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.result.UserList;

public interface GettingAUserList {

    /**
     * First OpenID pulled. If no input as null, default is to start from beginning
     *
     * @param openid
     * @return
     */
    @RelativePath("/cgi-bin/user/get")
    UserList userList(@ParamName("next_openid") String openid);

}
