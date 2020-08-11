package org.leon.example.springaop;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 19:47
 * @Description:
 */
public class AccountAspect extends BaseAspect{
    @Override
    public boolean isIntercept( Method method, Object[] objects) throws Throwable {
        return method.getName().equals("transfer");
    }

    @Override
    public void before() throws Throwable {
        System.out.println("对转账人身份进行验证");
    }
}
