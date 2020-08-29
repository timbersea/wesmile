package com.qian.wesmile.util;

import com.qian.wesmile.model.result.AccessToken;

public interface AccessTokenManger {
    /**
     * get the token cached, if null or expired the framework will process it well
     *
     * @return
     */
    AccessToken get();

    /**
     * save the token to anywhere by anyway
     *
     * @param accessToken
     */
    void save(AccessToken accessToken);
}
