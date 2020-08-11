package org.leon.example;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 15:29
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        IAccountService target = new AccountServiceImpl();
        AccountProxy proxy = new AccountProxy(target);
        proxy.transfer();
    }
}
