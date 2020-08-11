package org.leon.example;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 17:24
 * @Description:
 */
public class Client2 {
    public static void main(String[] args) {
        AccountService target = new AccountService();
        AccountService proxy = (AccountService) Enhancer.create(target.getClass(),new AccountAdvice2());
        proxy.transfer();
    }
}
