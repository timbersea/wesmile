package com.qian.core;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class WeChat {
    /**
     * 默认微信接口域名
     */
    private static final String DEFAULT_API_HOST = "https://api.weixin.qq.com";

    private String apiHost;
    private String appid;
    private String appSecret;
    private Retrofit retrofit;
    private WeChatTokenStorage wxTokenStorage;
    private boolean enableLog = true;
    private OkHttpClient okHttpClient;
    private Interceptor interceptor;

    // region 构造器

    /**
     * 无参构造，后续必须调用 init(appid,appSecret) 初始化
     */
    public WeChat() {
    }

    /**
     * 最简：必传 appid、appSecret，host、storage 使用默认
     */
    public WeChat(String appid, String appSecret) {
        this(appid, appSecret, DEFAULT_API_HOST, new InMemoryWxTokenStorage(), true);
    }

    /**
     * 自定义全部参数
     */
    public WeChat(String appid, String appSecret, String apiHost, WeChatTokenStorage wxTokenStorage,
                  boolean enableLog) {
        this.appid = appid;
        this.appSecret = appSecret;
        this.apiHost = apiHost;
        this.wxTokenStorage = wxTokenStorage;
    }
    // endregion

    /**
     * 无参构造后，手动初始化（必传appid、appSecret，其余默认）
     */
    public void init(String appid, String appSecret) {
        this.init(appid, appSecret, DEFAULT_API_HOST, new InMemoryWxTokenStorage());
    }

    /**
     * 无参构造后，手动初始化，可自定义host、storage
     */
    public void init(String appid, String appSecret, String apiHost, WeChatTokenStorage wxTokenStorage) {
        if (appid == null || appid.trim().isEmpty()) {
            throw new IllegalArgumentException("appid 不能为空");
        }
        if (appSecret == null || appSecret.trim().isEmpty()) {
            throw new IllegalArgumentException("appSecret 不能为空");
        }
        this.appid = appid;
        this.appSecret = appSecret;
        this.apiHost = apiHost == null || apiHost.trim().isEmpty() ? DEFAULT_API_HOST : apiHost;
        this.wxTokenStorage = wxTokenStorage == null ? new InMemoryWxTokenStorage() : wxTokenStorage;
        this.buildRetrofit();
    }

    public <T> T createService(Class<T> clazz) {
        if (retrofit == null) {
            throw new IllegalStateException("WeChat 尚未初始化，请先调用 init(appid,appSecret)");
        }
        return retrofit.create(clazz);
    }

    private void buildRetrofit() {
        OkHttpClient client = buildOkHttpClient();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(apiHost)
                .client(client)
                .addConverterFactory(WeChatResponseConverterFactory.wrap(JacksonConverterFactory.create()))
                .addCallAdapterFactory(DirectCallAdapterFactory.create())
                .build();
    }

    @NotNull
    private OkHttpClient buildOkHttpClient() {


        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new com.qian.interceptor.WeChatTokenRetryInterceptor(this.appid, this.appSecret,
                        this.wxTokenStorage));
        if (enableLog) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        return builder.build();
    }

    // 可选 getter
    public String getAppid() {
        return appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getApiHost() {
        return apiHost;
    }

    public WeChatTokenStorage getWxTokenStorage() {
        return wxTokenStorage;
    }
}