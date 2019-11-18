package com.qian.wesmile.request;

import com.alibaba.fastjson.JSON;
import com.qian.wesmile.WeSmile;
import com.qian.wesmile.annotation.JsonBody;
import com.qian.wesmile.annotation.ParamName;
import com.qian.wesmile.annotation.RelativePath;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author wuhuaiqian
 */
public class PlainTextRequestGenerator implements RequestGenerator {
    private Method method;
    private Object[] paramsValue;

    public PlainTextRequestGenerator(final Method method, final Object[] paramsValue) {
        this.method = method;
        this.paramsValue = paramsValue;
    }

    @Override
    public String getUrl() {
        RelativePath annotation = method.getAnnotation(RelativePath.class);
        Parameter[] parameters = method.getParameters();

        StringBuffer sb = new StringBuffer();
        sb.append(WeSmile.domain);
        sb.append(annotation.value());
        sb.append("?access_token=");
        sb.append("%s");
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
        return sb.toString();
    }


    @Override
    public String getJsonBody() {
        Parameter[] parameters = method.getParameters();
        if (paramsValue != null && paramsValue.length > 0) {
            Class<? extends Parameter> aClass = parameters[0].getClass();
            if (!aClass.isPrimitive()) {
                return JSON.toJSONString(paramsValue[0]);
            }
        }
        return "{}";
    }
}
