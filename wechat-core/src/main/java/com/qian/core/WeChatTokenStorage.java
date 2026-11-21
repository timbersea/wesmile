package com.qian.core;


public interface WeChatTokenStorage {
    /**
     * 获取缓存token
     *
     * @return token，null代表无有效缓存
     */
    String getToken();

    /**
     * 保存token
     *
     * @param token         access_token
     * @param expireSeconds 微信返回expires_in（7200），内部提前60s失效
     */
    void saveToken(String token, long expireSeconds);

    /**
     * 主动清除token（40001时调用）
     */
    void clearToken();
}

