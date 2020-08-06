package org.leon.anno.demo1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: liyang27
 * @Date: 2020/8/6 10:23
 * @Description:
 * 在注解上定义的成员变量只能是基本数据类型，String、Class、枚举类、注解以及以上类型的数组
 * 如果注解上只有一个属性，并且属性的名称为value，那么在使用的时候，我们可以不写value，直接赋值给它就行
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String name() default "leon";
    int age() default 26;
}
