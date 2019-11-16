package com.qian.wesmile.annotation;

import java.lang.annotation.*;

/**
 * 标明参数应该是json传递
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface JsonBody {
}