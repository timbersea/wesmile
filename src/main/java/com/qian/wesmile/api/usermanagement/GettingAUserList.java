package com.qian.wesmile.api.usermanagement;

import com.qian.wesmile.annotation.Api;
import com.qian.wesmile.annotation.ParamName;
import com.qian.wesmile.annotation.RelativePath;
import com.qian.wesmile.model.result.UserList;

@Api
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
