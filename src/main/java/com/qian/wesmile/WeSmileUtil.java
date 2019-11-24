package com.qian.wesmile;


public class WeSmileUtil {
    private static WeSmile weSmile;

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
