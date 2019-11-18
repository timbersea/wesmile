package com.qian.wesmile;

import com.qian.wesmile.proxy.APIInvocationHandler;
import com.qian.wesmile.request.AbstractHttpRequester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.lang.reflect.Proxy;

/**
 * @author wuhuaiqian
 */
public class WeSmile {
    private static final Logger log = LoggerFactory.getLogger(WeSmile.class);
    public static String appid;
    public static String appSecret;
    private static final String DEFAULT_DOMAIN = "https://api.weixin.qq.com";
    public static String domain = DEFAULT_DOMAIN;
    private APIInvocationHandler apiInvocationHandler = new APIInvocationHandler();
    private AbstractHttpRequester abstractHttpRequester;


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
     * @param <T>
     * @return the instance
     */
    //TODO maybe should cache the proxy class
    public <T> T getInstance(Class<T> clazz) {
        T proxy = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, apiInvocationHandler);
        return proxy;
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

    public AbstractHttpRequester getAbstractHttpRequester() {
        return abstractHttpRequester;
    }

    public void setAbstractHttpRequester(AbstractHttpRequester abstractHttpRequester) {
        this.abstractHttpRequester = abstractHttpRequester;
    }

}
