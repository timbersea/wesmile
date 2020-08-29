package com.qian.wesmile.util;

import com.qian.wesmile.model.result.AccessToken;

public class MemoryAccessTokenManager implements AccessTokenManger {
    private AccessToken accessToken;

    @Override
    public AccessToken get() {
        return accessToken;
    }

    @Override
    public void save(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}
