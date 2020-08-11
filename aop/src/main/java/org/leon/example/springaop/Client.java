package org.leon.example.springaop;

import org.leon.example.AccountServiceImpl;
import org.leon.example.IAccountService;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 19:52
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        IAccountService target = new AccountServiceImpl();
        BaseAspect accountAspect = new AccountAspect();
        IAccountService proxy = (IAccountService) ProxyFactory.createProxy(target.getClass(),accountAspect);
        proxy.transfer();
    }
}
