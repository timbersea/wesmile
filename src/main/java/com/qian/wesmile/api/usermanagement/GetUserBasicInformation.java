package com.qian.wesmile.api.usermanagement;

import com.qian.wesmile.annotation.ParamName;
import com.qian.wesmile.annotation.RelativePath;
import com.qian.wesmile.model.result.GetOpenId;
import com.qian.wesmile.model.result.UserInfo;

public interface GetUserBasicInformation {
    String grantType = "authorization_code";

    /**
     * @param openid the openid of user
     * @param lang   country / region language version
     * @return
     */
    @RelativePath("/cgi-bin/user/info")
    UserInfo userInfo(@ParamName("openid") String openid, @ParamName("lang") String lang);

    @RelativePath("/sns/oauth2/")
    GetOpenId oauth2(@ParamName("appid") String appid,
                     @ParamName("secret") String secret,
                     @ParamName("code") String code,
                     @ParamName("grant_type") String grant_type);

}
