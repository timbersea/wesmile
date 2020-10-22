package com.qian.wesmile;

import com.qian.wesmile.proxy.APIInvocationHandler;
import com.qian.wesmile.request.AbstractHttpRequester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuhuaiqian
 */
public class WeSmile {
    private static final Logger log = LoggerFactory.getLogger(WeSmile.class);

    private static final String DEFAULT_DOMAIN = "https://api.weixin.qq.com";

    public static String appid;

    public static String appSecret;

    public static String domain = DEFAULT_DOMAIN;

    private final APIInvocationHandler apiInvocationHandler = new APIInvocationHandler();


    private static final ConcurrentHashMap cache = new ConcurrentHashMap();

    public WeSmile() {
    }

    @PostConstruct
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
        WeSmile.appid = appid;
    }

    public void setAppSecret(String appSecret) {
        WeSmile.appSecret = appSecret;
    }

    public void setDomain(String domain) {
        WeSmile.domain = domain;
    }

    public void setHttpRequester(AbstractHttpRequester defaultHttpRequester) {
        if (defaultHttpRequester == null) {
            throw new IllegalArgumentException("defaultHttpRequester should't be null");
        }
        apiInvocationHandler.setDefaultHttpRequester(defaultHttpRequester);
    }
}
