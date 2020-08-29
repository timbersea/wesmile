package com.qian.wesmile.proxy;

import com.qian.wesmile.annotation.RelativePath;
import com.qian.wesmile.request.AbstractHttpRequester;
import com.qian.wesmile.request.OkHttpRequester;
import com.qian.wesmile.request.PlainTextRequestGenerator;
import com.qian.wesmile.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class APIInvocationHandler implements InvocationHandler {
    private static final Logger log = LoggerFactory.getLogger(APIInvocationHandler.class);

    private AbstractHttpRequester defaultHttpRequester = new OkHttpRequester();


    public APIInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        checkAnnotation(method);

        String url = PlainTextRequestGenerator.getUrl(method, args);
        String jsonBody = PlainTextRequestGenerator.getJsonBody(method, args);

        String result = defaultHttpRequester.call(url, jsonBody);
        Class<?> returnType = method.getReturnType();
        if (void.class == returnType) {
            return null;
        }
        //TODO 这里无法正常解析出数据到底是返回一个属性是空的对象还是直接招聘运行时异常有等商榷
        return JsonUtil.deserialize(result, returnType);
    }

    private void checkAnnotation(Method method) {
        if (!method.isAnnotationPresent(RelativePath.class)) {
            throw new RuntimeException(method.toString() + " must with annotation ＠RelativePath ");
        }
    }

    public void setDefaultHttpRequester(AbstractHttpRequester defaultHttpRequester) {
        this.defaultHttpRequester = defaultHttpRequester;
    }
}
