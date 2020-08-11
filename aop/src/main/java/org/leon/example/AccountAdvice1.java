package org.leon.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 15:34
 * @Description:
 */
public class AccountAdvice1 implements InvocationHandler {
    private IAccountService target;
    public AccountAdvice1(IAccountService target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        return method.invoke(target,args);
    }

    private void before(){
        System.out.println("对转账人身份进行验证");
    }
}
