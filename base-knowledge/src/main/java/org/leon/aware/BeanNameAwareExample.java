package org.leon.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 22:11
 * @Description:BeanNameAware提供声明bean时的id
 */
@Component("bean")
public class BeanNameAwareExample implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("beanName = " + s);
    }
}
