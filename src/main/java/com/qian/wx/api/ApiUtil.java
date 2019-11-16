package com.qian.wx.api;

import com.qian.wx.proxy.APIInvocationHandler;

import java.lang.reflect.Proxy;

public class ApiUtil {
    private static APIInvocationHandler apiInvocationHandler;

    private static final String DEFAULT_DOMAIN = "https://api.weixin.qq.com";


    /**
     * init wiht default domain @see DEFAULT_DOMAIN
     * @param appid your appid
     * @param appSecret your appSecret
     */
    public static void init(String appid, String appSecret) {
        if (apiInvocationHandler == null){
            apiInvocationHandler = new APIInvocationHandler(DEFAULT_DOMAIN, appid, appSecret);
        }
    }

    /**
     * init with Specific domain
     * @param domain the domain
     * @param appid your appid
     * @param appSecret your appSecret
     */

    public static void init(String domain, String appid, String appSecret) {
        if(apiInvocationHandler==null){
            apiInvocationHandler = new APIInvocationHandler(domain, appid, appSecret);
        }
    }


    /**
     * get you api iml same as the interface of Mybatis
     * @param clazz the class which the API define in the interface
     * @param <T>
     * @return the instance
     */
    public static <T> T getInstance(Class<T> clazz) {
        T proxy = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, apiInvocationHandler);
        return proxy;
    }

}
