package org.leon.annotation;

import org.leon.constant.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: liyang27
 * @Date: 2020/8/4 21:05
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    //请求路径
    String value() default "";
    //请求方法
    RequestMethod method() default RequestMethod.GET;
}


