package org.leon.example;

/**
 * @Author: liyang27
 * @Date: 2020/8/10 15:22
 * @Description:
 */
public class AccountProxy implements IAccountService{
    private IAccountService target;
    public AccountProxy(IAccountService target){
        this.target=target;
    }
    public void transfer() {
        before();
        target.transfer();
    }
    private void before(){
        System.out.println("对转账人身份进行验证");
    }
}
