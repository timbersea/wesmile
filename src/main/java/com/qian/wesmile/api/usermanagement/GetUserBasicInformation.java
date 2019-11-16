package com.qian.wesmile.api.usermanagement;

import com.qian.wesmile.annotation.ParamName;
import com.qian.wesmile.annotation.RelativePath;
import com.qian.wesmile.model.result.UserInfo;

public interface GetUserBasicInformation {
    /**
     * @param openid the openid of user
     * @param lang country / region language version
     * @return
     */
    @RelativePath("/cgi-bin/user/info")
    UserInfo userInfo(@ParamName("openid") String openid, @ParamName("lang") String lang);

}
