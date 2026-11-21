package com.qian.core;


public class InMemoryWxTokenStorage implements WeChatTokenStorage {
    private static final long SAFE_EXPIRE_OFFSET = 60 * 1000L;
    private final Object lock = new Object();
    private volatile String token;
    private volatile long expireTime = 0L;

    @Override
    public String getToken() {
        long now = System.currentTimeMillis();
        if (token != null && now < expireTime - SAFE_EXPIRE_OFFSET) {
            return token;
        }
        return null;
    }

    @Override
    public void saveToken(String token, long expireSeconds) {
        synchronized (lock) {
            this.token = token;
            this.expireTime = System.currentTimeMillis() + expireSeconds * 1000L;
        }
    }

    @Override
    public void clearToken() {
        synchronized (lock) {
            this.token = null;
            this.expireTime = 0L;
        }
    }
}

