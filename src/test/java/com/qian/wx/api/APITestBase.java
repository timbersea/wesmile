package com.qian.wx.api;

import com.alibaba.fastjson.JSON;
import com.qian.wx.api.config.Config;
import com.qian.wx.api.config.MyAPIConfig;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;

public abstract class APITestBase<T> {

    private static final Logger log = LoggerFactory.getLogger(APITestBase.class);
    Config config = new MyAPIConfig();

    protected  T api;
    protected Object result;

    private String domain = "https://api.weixin.qq.com";

    @Before
    public void setUp() throws Exception {
        ApiUtil.init(config.getAppid(), config.getAppsecret());
        ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> aClass = (Class) pt.getActualTypeArguments()[0];
       api= ApiUtil.getInstance(aClass);
    }

    @After
    public void logResult() {
        log.info(JSON.toJSONString(result));
    }
}
