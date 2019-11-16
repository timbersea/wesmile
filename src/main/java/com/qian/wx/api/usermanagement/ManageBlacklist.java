package com.qian.wx.api.usermanagement;

import com.qian.wx.annotation.JsonBody;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.param.BeginOpenId;
import com.qian.wx.model.param.OpenIdList;
import com.qian.wx.model.result.ManageBlacklistReuslt;

public interface ManageBlacklist {

    /**
     * Obtain blacklists of an Official Account
     *
     * @param beginOpenId with the property begin_id
     * @return openid in backlist
     */
    @RelativePath("/cgi-bin/tags/members/getblacklist")
    ManageBlacklistReuslt getblacklist(@JsonBody BeginOpenId beginOpenId);

    /**
     * Official Account blacklist a batch of users through this interface.
     *
     * @param openIdList A blacklist is composed of a string of OpenID
     * @return
     */
    @RelativePath("/cgi-bin/tags/members/batchblacklist")
    void batchblacklist(@JsonBody OpenIdList openIdList);


    /**
     * Official Account can unblock a batch of users through this interface
     *
     * @param openIdList A blacklist is composed of a string of OpenID
     */
    @RelativePath("/cgi-bin/tags/members/batchunblacklist")
    void batchunblacklist(@JsonBody OpenIdList openIdList);
}
