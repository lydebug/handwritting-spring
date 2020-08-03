package org.leon.bpp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 22:33
 * @Description:
 */
@Component("anotherExampleBean")
public class AnotherExampleBean implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
