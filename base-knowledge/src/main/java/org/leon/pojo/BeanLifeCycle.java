package org.leon.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author: liyang27
 * @Date: 2020/8/4 09:15
 * @Description:
 */

@Configuration
@ComponentScan("org.leon.pojo")
public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");

//        ApplicationContext factory = new ClassPathXmlApplicationContext("springBeanTest/beans.xml");
        ApplicationContext factory = new AnnotationConfigApplicationContext(BeanLifeCycle.class);
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((AnnotationConfigApplicationContext)factory).registerShutdownHook();
    }
}
