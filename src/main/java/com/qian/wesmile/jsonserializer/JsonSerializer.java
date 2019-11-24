package com.qian.wesmile.jsonserializer;


/**
 * 默认使用的是ali 的fastjson,所有的参数和返回结果的bean都是用的下划线方式以适配微信平台返回的结果，
 * 如果你非要严格使用驼峰方式的bean，自行实现此接口，但是会导致com.qian.wesmile.api包下所有的已经声明的接口
 * 无法正确返回结果，所以需要你自己行将所有接口参数及返回bean的类型声明
 */
public interface JsonSerializer {

    /**
     * 请求体中的参数转json，当你的参数bean中使用驼峰命名的方式时，你必须正确的转为微信API所需要的下划线形式的参数
     *
     * @param jsonBodyBean
     * @return must be snake case json key
     */
    String serialize(Object jsonBodyBean);

    /**
     * json 转java bean，api底层返回的下划线风格的json，如果非要使用驼峰命名的bean这自行定义
     *
     * @param jsonString result by we chat server which is snake case style json
     * @param clazz      the api interface return type
     * @return the api interface return result
     */
    Object deserialize(String jsonString, Class clazz);

}
