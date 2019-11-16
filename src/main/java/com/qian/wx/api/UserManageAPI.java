package com.qian.wx.api;

import com.qian.wx.annotation.JsonBody;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.param.UserTag;
import com.qian.wx.model.result.Tags;

/**
 * Custom Menus defines
 */
public interface UserManageAPI {
    @RelativePath("/cgi-bin/tags/create")
    UserTag createTag(@JsonBody UserTag tagManage);

    @RelativePath("/cgi-bin/tags/get")
    Tags getTags();
}
