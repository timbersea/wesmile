package com.qian.wesmile.api;

import com.qian.wesmile.proxy.APIInvocationHandler;
import com.qian.wesmile.request.AbstractHttpRequester;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuhuaiqian
 */
public class WeSmile {
    private static final String DEFAULT_DOMAIN = "https://api.weixin.qq.com";
    private APIInvocationHandler apiInvocationHandler;

    private static ConcurrentHashMap proxyCache = new ConcurrentHashMap();
    private String appid;
    private String appSecret;


    public WeSmile() {
    }

    public WeSmile(String appid, String appSecret, String getDomain) {
        this.apiInvocationHandler = new APIInvocationHandler(getDomain, appid, appSecret);
    }

    public WeSmile(String appid, String appSecret) {
        apiInvocationHandler = new APIInvocationHandler(DEFAULT_DOMAIN, appid, appSecret);
    }

    public WeSmile(String appid, String appSecret, String getDomain, AbstractHttpRequester httpRequester) {
        this.apiInvocationHandler = new APIInvocationHandler(getDomain, appid, appSecret, httpRequester);
    }

    public WeSmile(String appid, String appSecret, AbstractHttpRequester httpRequester) {
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
        if (apiInvocationHandler == null) {
            this.apiInvocationHandler = new APIInvocationHandler(DEFAULT_DOMAIN, appid, appSecret);
        }

        T proxy = null;
        Object o = proxyCache.get(clazz);
        if (o == null) {
            Object o1 = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, apiInvocationHandler);
            proxyCache.put(clazz, o1);
        }
        proxy = (T) o;
        return proxy;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
