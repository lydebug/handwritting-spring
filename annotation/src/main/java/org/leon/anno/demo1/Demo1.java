package org.leon.anno.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: liyang27
 * @Date: 2020/8/6 10:31
 * @Description:
 * 把自定义注解的基本信息注入到方法上：
 * 1 反射出该类的方法
 * 2 通过方法得到注解上的具体信息
 * 将注解上的信息注入到方法上
 */
public class Demo1 {
    @MyAnnotation
    public void add(String userName,int age){
        System.out.println(userName+age);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class demo1_class=Demo1.class;
        Method method = demo1_class.getMethod("add",String.class,int.class);

        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        String userName=annotation.name();
        int age=annotation.age();

        Object o = demo1_class.getConstructor().newInstance();
        method.invoke(o,userName,age);
    }
}
