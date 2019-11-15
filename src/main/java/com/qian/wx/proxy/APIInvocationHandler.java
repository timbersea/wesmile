package com.qian.wx.proxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.qian.wx.annotation.JsonBody;
import com.qian.wx.annotation.ParamName;
import com.qian.wx.annotation.RelativePath;
import com.qian.wx.model.result.APIResult;
import com.qian.wx.model.result.AccessToken;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class APIInvocationHandler implements InvocationHandler {
    private static final Logger log = LoggerFactory.getLogger(APIInvocationHandler.class);

    private static String GET_ACCESS_TOKEN_URL_PATTERN = "%s/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    private static OkHttpClient client = new OkHttpClient();
    private static Request.Builder builder = new Request.Builder();
    protected String domain;
    protected String appid;
    protected String appSecret;
    private AccessToken accessToken;

    public APIInvocationHandler(String domain, String appid, String appSecret) {
        this.domain = domain;
        this.appid = appid;
        this.appSecret = appSecret;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        checkAnnotation(proxy,method,args);
        Class<?> returnType = method.getReturnType();
        String result = doAPIRequest(method, args);
        try {
            //TODO 这里无法正常解析出数据到底是返回一个属性是空的对象还是直接招聘运行时异常有等商榷
            APIResult apiResult = JSON.parseObject(result, APIResult.class);
            if (apiResult.success()) {
                return JSON.parseObject(result, returnType);
            }
            else {
                throw new RuntimeException(result + " can't parse to {}" + returnType);
            }
        } catch (Exception e) {
            throw new RuntimeException(result + " can't parse to {}" + returnType);
        }
    }
    private void checkAnnotation(Object proxy, Method method, Object[] args){
        if(!method.isAnnotationPresent(RelativePath.class)){
            throw new RuntimeException(method.toString()+" must with annotation ＠RelativePath ");
        }
    }

    //    protected String doRequest(String url,){
    //
    //    }

    /**
     * 把通过url地址传递的参数拼接到url后面,自动处理accessToken的值
     *
     * @param annotation
     * @param parameters
     * @param paramsValue
     * @return
     */
    public String getUrlWithAddressParams(RelativePath annotation, Parameter[] parameters,
                                          Object[] paramsValue) {
        StringBuffer sb = new StringBuffer();
        sb.append(domain);
        sb.append(annotation.value());
        sb.append("?access_token=");
        sb.append(getAccessToken());
        sb.append("&");
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
        log.debug(sb.toString());
        return sb.toString();

    }

    private String getAccessToken() {
        if (accessToken == null || accessToken.isExpire()) {
            return getAccessTokenByRequest().getAccessToken();
        }

        return accessToken.getAccessToken();
        //                  return "27_R-y1HA9fcQAtdEBjFD6TxPhi_3ujSqjhgRdmuFvrdE16hBspqNWP6PWro4kLFDMI4x1HsKBwLHI7K9V" +
        //          "-jiFazAKGCqE-f5WlUX1yPuODlXmcLxkIPcAKIu--IO3yFGuw0EhR1fj-a72UeLzQTKMeACAXOQ";

    }

    private AccessToken getAccessTokenByRequest() {
        String url = String.format(GET_ACCESS_TOKEN_URL_PATTERN, domain, appid, appSecret);
        Request request = builder.url(url).build();
        String string = "";
        try (Response response = client.newCall(request).execute()) {
            string = response.body().string();
            log.debug("request accessToken response {}", string);
            AccessToken accessToken = JSON.parseObject(string, AccessToken.class);
            this.accessToken = accessToken;
            return accessToken;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (JSONException e) {
            throw new RuntimeException("can't pare accessToken from response " + string + " please check config");
        }
    }

    private String doAPIRequest(Method method, Object[] args) {

        RelativePath annotation = method.getAnnotation(RelativePath.class);
        Parameter[] parameters = method.getParameters();

        String url = getUrlWithAddressParams(annotation, parameters, args);

        String s = "";
        if(args!=null&&args.length>0){
            Class<? extends Parameter> aClass = parameters[0].getClass();
            if (!aClass.isPrimitive()) {
                s = JSON.toJSONString(args[0]);
            }
        }

        RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), s);
        Request build = builder.url(url).post(requestBody).build();
        try (Response response = client.newCall(build).execute()) {

            String result = new String(response.body().bytes());
            log.debug("response {}", result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
