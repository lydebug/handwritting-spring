package org.leon.example;

import java.lang.reflect.Proxy;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 15:46
 * @Description:
 */
public class Client1 {
    public static void main(String[] args) {
        IAccountService target = new AccountServiceImpl();
        IAccountService proxy=(IAccountService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new AccountAdvice1(target));
        proxy.transfer();
    }
}
