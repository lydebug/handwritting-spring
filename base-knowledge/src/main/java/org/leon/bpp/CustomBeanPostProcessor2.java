package org.leon.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 22:32
 * @Description:
 */

@Component
public class CustomBeanPostProcessor2 implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean执行init()方法之前的定制逻辑2.");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean执行init()方法之后的定制逻辑2.");
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
