package com.qian.wesmile.api.com.qian.wx.api.usermanagement;

import com.qian.wesmile.api.APITestBase;
import com.qian.wesmile.api.usermanagement.UserTagManagement;
import com.qian.wesmile.model.param.UserTag;
import com.qian.wesmile.model.result.Tags;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTagManagementTest extends APITestBase<UserTagManagement> {
    private static final Logger log = LoggerFactory.getLogger(UserTagManagementTest.class);

    int beforeAddTagNumber;
    @Test
    public void getTags() {
        Tags tags = api.getTags();
        beforeAddTagNumber=tags.getTags().size();
        result = tags;
    }


    @Test
    public void createTag() {
        UserTag userTag = new UserTag();
        UserTag.TagBean tagBean = new UserTag.TagBean();
        tagBean.setName(Math.random() + "");
        userTag.setTag(tagBean);
        result = api.createTag(userTag);
    }

    @Test
    public void editingTags() {
        UserTag userTag = new UserTag();
        UserTag.TagBean tagBean = new UserTag.TagBean();
        tagBean.setId(100);
        tagBean.setName(Math.random() + "");
        userTag.setTag(tagBean);
        api.editingTags(userTag);
    }


}
