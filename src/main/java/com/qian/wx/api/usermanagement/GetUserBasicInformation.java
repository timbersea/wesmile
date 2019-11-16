package com.qian.wx.api.usermanagement;

import com.qian.wx.annotation.ParamName;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.result.UserInfo;

public interface GetUserBasicInformation {
    /**
     * @param openid the openid of user
     * @param lang country / region language version
     * @return
     */
    @RelativePath("/cgi-bin/user/info")
    UserInfo userInfo(@ParamName("openid") String openid, @ParamName("lang") String lang);

}
