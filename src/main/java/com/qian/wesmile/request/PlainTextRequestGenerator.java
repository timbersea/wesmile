package com.qian.wesmile.request;

import com.qian.wesmile.WeSmile;
import com.qian.wesmile.annotation.JsonBody;
import com.qian.wesmile.annotation.ParamName;
import com.qian.wesmile.annotation.RelativePath;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author wuhuaiqian
 */
public final class PlainTextRequestGenerator {

    public static String getUrl(final Method method, final Object[] paramsValue) {
        RelativePath annotation = method.getAnnotation(RelativePath.class);
        Parameter[] parameters = method.getParameters();
        String path = annotation.value();

        StringBuffer sb = new StringBuffer();
        sb.append(WeSmile.domain);
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

    public static String getJsonBody(final Method method, final Object[] paramsValue) {
        if (paramsValue != null && paramsValue.length > 0) {
            Class<?> aClass = paramsValue[0].getClass();
            if (!aClass.isPrimitive() && !aClass.equals(String.class)) {
                return WeSmile.jsonSerializer.serialize(paramsValue[0]);
            }
        }
        return null;
    }
}
