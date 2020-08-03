package org.leon.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 22:19
 * @Description:
 */
@Component("applicationContextAwareExample")
public class ApplicationContextAwareExample implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext = " + applicationContext);
    }
}
