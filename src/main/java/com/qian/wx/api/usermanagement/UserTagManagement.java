package com.qian.wx.api.usermanagement;

import com.qian.wx.annotation.JsonBody;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.param.UserTag;
import com.qian.wx.model.result.Tags;

public interface UserTagManagement {
    /**
     * Creating a Tag
     *
     * @param userTagWithUniqueName the tagManage.tag.name must no exist in and tagManage.tag.id should be null
     * @return {@link  UserTag} with generate id
     */
    @RelativePath("/cgi-bin/tags/create")
    UserTag createTag(@JsonBody UserTag userTagWithUniqueName);

    /**
     * Getting Tags Created by the Official Account
     *
     * @return
     */
    @RelativePath("/cgi-bin/tags/get")
    Tags getTags();

    /**
     * Editing Tags
     */
    @RelativePath("/cgi-bin/tags/update")
    void editingTags(UserTag userTag);
}
