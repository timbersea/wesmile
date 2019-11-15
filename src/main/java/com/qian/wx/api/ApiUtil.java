package com.qian.wx.api;

import com.qian.wx.invocation.APIInvocationHandler;

import java.lang.reflect.Proxy;

public class ApiUtil {
    private static final String DEFAULT_DOMAIN = "https://api.weixin.qq.com";

    /**
     * @param domain
     * @param appid
     * @param appSecret
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getInstance(String domain, String appid, String appSecret, Class<T> clazz) {
        APIInvocationHandler apiInvocationHandler = new APIInvocationHandler(domain, appid, appSecret);
        T proxy = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, apiInvocationHandler);
        return proxy;
    }

    public static <T> T getInstance(String appid, String appSecret, Class<T> clazz) {
        APIInvocationHandler apiInvocationHandler = new APIInvocationHandler(DEFAULT_DOMAIN, appid, appSecret);
        T proxy = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, apiInvocationHandler);
        return proxy;
    }

}
