package com.qian.wesmile.api.com.qian.wx.api.usermanagement;

import com.qian.wesmile.WeSmile;
import com.qian.wesmile.api.APITestBase;
import com.qian.wesmile.api.usermanagement.GetUserBasicInformation;
import com.qian.wesmile.model.param.UserTag;
import org.junit.Test;

public class GetUserBasicInformationTest extends APITestBase<GetUserBasicInformation> {

    @Test
    public void oauth2() {
        UserTag userTag = new UserTag();
        UserTag.TagBean tagBean = new UserTag.TagBean();
        tagBean.setId(100);
        tagBean.setName(Math.random() + "");
        userTag.setTag(tagBean);
        api.oauth2(WeSmile.appid, WeSmile.appSecret, "011jXYAb1knvWw0jcIAb1RdMAb1jXYAK", "authorization_code");
    }

    @Test
    public void snsUserInfo() {
        api.snsUserInfo("aa", "dfd", "zh_CN");

    }
}
