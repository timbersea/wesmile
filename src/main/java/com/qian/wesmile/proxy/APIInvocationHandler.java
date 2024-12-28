package com.qian.wesmile.proxy;

import com.qian.wesmile.annotation.JsonBody;
import com.qian.wesmile.annotation.ParamName;
import com.qian.wesmile.annotation.RelativePath;
import com.qian.wesmile.exception.ApiException;
import com.qian.wesmile.model.result.APIResult;
import com.qian.wesmile.model.result.AccessToken;
import com.qian.wesmile.request.AbstractHttpRequester;
import com.qian.wesmile.request.OkHttpRequester;
import com.qian.wesmile.spi.AccessTokenManager;
import com.qian.wesmile.spi.MemoryAccessTokenManager;
import com.qian.wesmile.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


public class APIInvocationHandler implements InvocationHandler {
    private static final Logger log = LoggerFactory.getLogger(APIInvocationHandler.class);
    private AbstractHttpRequester abstractHttpRequester = new OkHttpRequester();
    private AccessTokenManager accessTokenManager = new MemoryAccessTokenManager();
    private static final String GET_ACCESS_TOKEN_URL_PATTERN = "%s/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    private volatile boolean needDoRequest = false;
    private final Object lock = new Object();
    private AccessToken accessToken = new AccessToken();
    private String appid;
    private String appSecret;
    private String domain;

    public APIInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        checkAnnotation(method);

        String url = getUrl(method, args);
        String jsonBody = getJsonBody(args);

        String result = doRequest(url, jsonBody);
        Class<?> returnType = method.getReturnType();
        if (void.class == returnType) {
            return null;
        }
        //TODO 这里无法正常解析出数据到底是返回一个属性是空的对象还是直接招聘运行时异常有等商榷
        return JsonUtil.deserialize(result, returnType);
    }


    private String doRequest(String url, String body) {
        String urlWithAccessToken = String.format(url, getAccessToken().getAccessToken());
        String result = abstractHttpRequester.sendHttpRequest(urlWithAccessToken, body);
        log.debug("url {} \r\n body {}", urlWithAccessToken, body);
        log.debug("result {}", result);
        APIResult apiResult = JsonUtil.deserialize(result, APIResult.class);
        if (apiResult.success()) {
            return result;
        }

        //42001	access_token expired	access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明
        //40001	invalid credential, access_token is invalid or not latest
        // 获取 access_token 时 AppSecret 错误，或者 access_token 无效。请开发者认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口
        boolean apiAccessTokenInvalid = apiResult.getErrcode() == 42001 || apiResult.getErrcode() == 40001;

        //这个接口返回access token无效，是因为通过/sns/oauth2/，code换取到access token无效，并不能通过刷新token来解决问题
        boolean notSnsOauth2 = !url.contains("/sns/userinfo");
        if (apiAccessTokenInvalid && notSnsOauth2) {
            onAccessTokenExpire();
            return doRequest(url, body);
        } else {
            throw new ApiException(result);
        }
    }

    private void checkAnnotation(Method method) {
        if (!method.isAnnotationPresent(RelativePath.class)) {
            throw new RuntimeException(method + " must with annotation ＠RelativePath ");
        }
    }

    public void setAbstractHttpRequester(AbstractHttpRequester abstractHttpRequester) {
        this.abstractHttpRequester = abstractHttpRequester;
    }

    public void setAccessTokenManger(AccessTokenManager accessTokenManger) {
        this.accessTokenManager = accessTokenManger;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    private void onAccessTokenExpire() {
        needDoRequest = true;
    }

    private AccessToken getAccessToken() {

        //重新拉取
        if (needDoRequest) {
            synchronized (lock) {//确保只有一个线程去请求最新的token
                if (needDoRequest) {//可能被前一个线程重新获取过了并将值修改为false
                    accessToken = fetchAccessTokenFromWeChatAndCache();
                } else {
                    accessToken.setAccessToken(accessTokenManager.getAccessToken());
                }
                return accessToken;
            }
        } else {
            accessToken.setAccessToken(accessTokenManager.getAccessToken());
            return accessToken;
        }
    }

    /**
     * 重新从微信服务器请求，并缓存
     *
     * @return 最新accesstoken
     */
    private AccessToken fetchAccessTokenFromWeChatAndCache() {
        String url = String.format(GET_ACCESS_TOKEN_URL_PATTERN, this.domain, this.appid, this.appSecret);
        log.debug("get new access token url:{}", url);
        String result = abstractHttpRequester.sendHttpRequest(url, null);
        log.debug("get new access  response {}", result);
        AccessToken accessToken = JsonUtil.deserialize(result, AccessToken.class);
        if (accessToken.getAccessToken() == null) {
            throw new ApiException(result);
        }
        if (!url.contains("/sns/oauth2/")) {//这个接口的access token和其它接口的不是同一个东西
            accessTokenManager.saveAccessToken(accessToken.getAccessToken());
        }
        needDoRequest = false;
        return accessToken;
    }

    private String getUrl(final Method method, final Object[] paramsValue) {
        RelativePath annotation = method.getAnnotation(RelativePath.class);
        Parameter[] parameters = method.getParameters();
        String path = annotation.value();

        StringBuilder sb = new StringBuilder();
        sb.append(this.domain);
        sb.append(path);
        //如果不是这个接口的话access_token是内部统一处理的,这个接口的access_token以在接口上以参数的形式传进来的
        if (!"/sns/userinfo".equals(path) && !"/sns/oauth2/access_token".equals(path)) {
            sb.append("?access_token=");
            sb.append("%s");
            sb.append("&");
        } else {
            sb.append("?");
        }
        for (int i = 0; i < parameters.length; i++) {
            Object value = paramsValue[i];
            Parameter p = parameters[i];
            //参数非空且不是请求体中传递的参数
            if (value != null && !p.isAnnotationPresent(JsonBody.class)) {
                ParamName pAnnotation = p.getAnnotation(ParamName.class);
                sb.append(pAnnotation.value());
                sb.append("=");
                sb.append(paramsValue[i]);
            }
            sb.append("&");
        }
        return sb.toString();
    }

    private String getJsonBody(final Object[] paramsValue) {
        if (paramsValue != null && paramsValue.length > 0) {
            Class<?> aClass = paramsValue[0].getClass();
            if (!aClass.isPrimitive() && !aClass.equals(String.class)) {
                return JsonUtil.serialize(paramsValue[0]);
            }
        }
        return null;
    }

}
