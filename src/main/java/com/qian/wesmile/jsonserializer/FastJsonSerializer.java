package com.qian.wesmile.jsonserializer;

import com.alibaba.fastjson.JSON;

public class FastJsonSerializer implements JsonSerializer {
    @Override
    public String serialize(Object o) {
        return JSON.toJSONString(o);
    }

    @Override
    public Object deserialize(String jsonString, Class clazz) {
        return JSON.parseObject(jsonString, clazz);
    }
}
