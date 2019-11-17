package com.qian.wesmile.api;

import com.qian.wesmile.proxy.APIInvocationHandler;
import com.qian.wesmile.request.AbstractHttpRequester;

import java.lang.reflect.Proxy;

/**
 * @author wuhuaiqian
 */
public class Api {
    private static final String DEFAULT_DOMAIN = "https://api.weixin.qq.com";
    private APIInvocationHandler apiInvocationHandler;


    public Api(String appid, String appSecret, String getDomain) {
        this.apiInvocationHandler = new APIInvocationHandler(getDomain, appid, appSecret);
    }

    public Api(String appid, String appSecret) {
        apiInvocationHandler = new APIInvocationHandler(DEFAULT_DOMAIN, appid, appSecret);
    }

    public Api(String appid, String appSecret, String getDomain, AbstractHttpRequester httpRequester) {
        this.apiInvocationHandler = new APIInvocationHandler(getDomain, appid, appSecret, httpRequester);
    }

    public Api(String appid, String appSecret, AbstractHttpRequester httpRequester) {
        apiInvocationHandler = new APIInvocationHandler(DEFAULT_DOMAIN, appid, appSecret, httpRequester);
    }

    /**
     * get you api iml same as the interface of Mybatis
     *
     * @param clazz the class which the API define in the interface
     * @param <T>
     * @return the instance
     */
    public <T> T getInstance(Class<T> clazz) {
        T proxy = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, apiInvocationHandler);
        return proxy;
    }
}
