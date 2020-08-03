package org.leon.bpp;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 22:31
 * @Description:
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


@Component
public class CustomBeanPostProcessor1 implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean执行init()方法之前的定制逻辑1.");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean执行init()方法之后的定制逻辑1.");
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}







//    bean执行init()方法之前的定制逻辑2.
//        bean执行init()方法之前的定制逻辑1.
//        init() ...
//        bean执行init()方法之后的定制逻辑2.
//        bean执行init()方法之后的定制逻辑1.


