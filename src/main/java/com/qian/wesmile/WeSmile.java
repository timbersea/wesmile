package com.qian.wesmile;

import com.qian.wesmile.proxy.APIInvocationHandler;
import com.qian.wesmile.request.AbstractHttpRequester;
import com.qian.wesmile.spi.AccessTokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuhuaiqian
 */
public class WeSmile {
    private static final Logger log = LoggerFactory.getLogger(WeSmile.class);

    private static final String DEFAULT_DOMAIN = "https://api.weixin.qq.com";

    private final ConcurrentHashMap<Class,Object> cache = new ConcurrentHashMap<>();
    private String appid;
    private String appSecret;
    private final String domain = DEFAULT_DOMAIN;

    private final APIInvocationHandler apiInvocationHandler = new APIInvocationHandler();

    {
        apiInvocationHandler.setAppid(appid);
        apiInvocationHandler.setAppSecret(appSecret);
        apiInvocationHandler.setDomain(domain);
    }


    public WeSmile() {
    }

    public void postConstruct() {
        log.info("we smile use domain:{} appid:{} appSecret:{}", domain, appid, appSecret);
    }

    /**
     * get you api iml same as the interface of Mybatis
     *
     * @param clazz the class which the API define in the interface
     * @param <T>   t
     * @return the instance
     */
    //maybe should cache the proxy class?
    @SuppressWarnings(value = "unchecked")
    public <T> T getInstance(Class<T> clazz) {
        return (T) cache.computeIfAbsent(clazz,
                k -> Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, apiInvocationHandler));
    }

    public void setAppid(String appid) {
        this.apiInvocationHandler.setAppid(appid);
    }

    public void setAppSecret(String appSecret) {
        this.apiInvocationHandler.setAppSecret(appSecret);
    }

    public void setDomain(String domain) {
        this.apiInvocationHandler.setDomain(domain);
    }

    public void setHttpRequester(AbstractHttpRequester abstractHttpRequester) {
        this.apiInvocationHandler.setAbstractHttpRequester(abstractHttpRequester);
    }

    public void setAccessTokenManager(AccessTokenManager accessTokenManager) {
        this.apiInvocationHandler.setAccessTokenManger(accessTokenManager);
    }
}
