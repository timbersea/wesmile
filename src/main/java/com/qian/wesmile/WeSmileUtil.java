package com.qian.wesmile;


import com.qian.wesmile.spi.AccessTokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeSmileUtil {
    private static WeSmile weSmile;

    private static final Logger log = LoggerFactory.getLogger(WeSmileUtil.class);


    /**
     * init use default domain @see DEFAULT_DOMAIN
     *
     * @param appid     your appid
     * @param appSecret your appSecret
     */
    public static void init(String appid, String appSecret) {
        weSmile = new WeSmile();
        weSmile.setAppid(appid);
        weSmile.setAppSecret(appSecret);
    }

    public static void setAccessTokenManager(AccessTokenManager accessTokenManager) {
        if (weSmile == null) {
            throw new RuntimeException("call com.qian.wesmile.WeSmileUtil.init(java.lang.String, java.lang.String) at first");
        }
        weSmile.setAccessTokenManager(accessTokenManager);
    }

    /**
     * init with Specific domain
     *
     * @param domain    the domain
     * @param appid     your appid
     * @param appSecret your appSecret
     */

    public static void init(String domain, String appid, String appSecret) {
        weSmile = new WeSmile();
        weSmile.setDomain(domain);
        weSmile.setAppid(appid);
        weSmile.setAppSecret(appSecret);
    }


    /**
     * get you api iml same as the interface of Mybatis
     *
     * @param clazz the class which the API define in the interface
     * @param <T>
     * @return the instance
     */
    public static <T> T getInstance(Class<T> clazz) {
        if (weSmile == null) {
            throw new RuntimeException("please call init at first");
        }
        return weSmile.getInstance(clazz);
    }

}
