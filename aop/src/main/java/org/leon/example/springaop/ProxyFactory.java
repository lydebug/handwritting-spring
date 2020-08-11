package org.leon.example.springaop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 19:49
 * @Description:
 */
public class ProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<?> targetClass, final MethodInterceptor methodInterceptor){
        return (T) Enhancer.create(targetClass,methodInterceptor);
    }
}
