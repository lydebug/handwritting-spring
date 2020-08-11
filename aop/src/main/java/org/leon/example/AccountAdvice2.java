package org.leon.example;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 16:21
 * @Description:
 */
public class AccountAdvice2 implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        return methodProxy.invokeSuper(o,objects);
//        return method.invoke(o,objects);
    }
    private void before(){
        System.out.println("对转账人身份进行验证。。");
    }
}
