package com.qian.wesmile.api;

import com.qian.wesmile.WeSmile;
import com.qian.wesmile.WeSmileUtil;
import com.qian.wesmile.api.analytics.UserAnalysisData;
import com.qian.wesmile.api.config.Config;
import com.qian.wesmile.api.config.MyAPIConfig;
import com.qian.wesmile.spi.AccessTokenManager;
import com.qian.wesmile.spi.FileAccessTokenManager;
import com.qian.wesmile.util.JsonUtil;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;

public abstract class APITestBase<T> {

    private static final Logger log = LoggerFactory.getLogger(APITestBase.class);

    Config config = new MyAPIConfig();

    protected T api;

    protected Object result;

    private final String domain = "https://api.weixin.qq.com";

    AccessTokenManager tokenManager = new FileAccessTokenManager();

    @Before
    public void setUp() throws Exception {
        WeSmileUtil.init(config.getAppid(), config.getAppsecret());
        WeSmileUtil.setAccessTokenManager(tokenManager);
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> aClass = (Class) pt.getActualTypeArguments()[0];
        api = WeSmileUtil.getInstance(aClass);
    }

    @After
    public void logResult() {
        log.info(JsonUtil.serialize(result));
        WeSmile weSmile = new WeSmile();

        UserAnalysisData instance = weSmile.getInstance(UserAnalysisData.class);
        //instance.getusercumulate();
    }
}
