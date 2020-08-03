package org.leon.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 22:16
 * @Description:
 */
@Component("beanFactoryAwareExample")
public class BeanFactoryAwareExample implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactoryAware:"+beanFactory);
    }
}
