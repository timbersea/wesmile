package com.qian.wesmile.api.usermanagement;

import com.qian.wesmile.annotation.ParamName;
import com.qian.wesmile.annotation.RelativePath;
import com.qian.wesmile.model.result.GetOpenId;
import com.qian.wesmile.model.result.SnsUserInfo;
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

    /**
     * 通过code换取网页授权access_token
     *
     * @param appid
     * @param secret
     * @param code
     * @param grant_type use default vale authorization_code
     * @return
     */
    @RelativePath("/sns/oauth2/access_token")
    GetOpenId oauth2(@ParamName("appid") String appid,
                     @ParamName("secret") String secret,
                     @ParamName("code") String code,
                     @ParamName("grant_type") String grant_type);


    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     *
     * @param accessToken
     * @param openid
     * @param lang  返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     */
    @RelativePath("/sns/userinfo")
    SnsUserInfo snsUserInfo(@ParamName("access_token") String accessToken,
                            @ParamName("openid") String openid,
                            @ParamName("lang") String lang);

}
