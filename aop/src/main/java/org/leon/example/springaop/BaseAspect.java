package org.leon.example.springaop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 19:32
 * @Description:
 */
public class BaseAspect implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result=null;
        begin();
        try {
            if(isIntercept(method,objects)){
                before();
                result=methodProxy.invokeSuper(o,objects);
                after();
            }else{
                result = methodProxy.invokeSuper(o,objects);
            }
        }catch (Exception e){
            error(e);
            throw e;
        }finally {
            end();
        }
        return result;
    }
    public void begin(){}
    public boolean isIntercept(Method method,Object[] args) throws Throwable{
        return true;
    }
    public void before() throws Throwable{}
    public void after() throws Throwable{}
    public void error(Throwable e){}
    public void end(){}
}
