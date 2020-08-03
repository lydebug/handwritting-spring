package org.leon;

import org.leon.aware.ApplicationContextAwareExample;
import org.leon.aware.BeanFactoryAwareExample;
import org.leon.aware.BeanNameAwareExample;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liyang27
 * @Date: 2020/8/3 21:50
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = "org.leon")
public class SpringApplication {
    public static void main(String[] args) {
        //不同的容器会产生不同的bean，Singleton只是说明同一个容器只会创建一个实例
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);
//        ApplicationContext context1 = new AnnotationConfigApplicationContext(SpringApplication.class);
//        IBookService bookService = context.getBean("bookService", BookServiceImpl.class);
//        IBookService bookService1 = context1.getBean("bookService", BookServiceImpl.class);
//        System.out.println(bookService);
//        System.out.println(bookService1);
//        bookService.addBook();


        BeanNameAwareExample beanNameAwareExample = context.getBean("bean", BeanNameAwareExample.class);
        System.out.println(beanNameAwareExample);
        BeanFactoryAwareExample beanFactoryAwareExample=context.getBean("beanFactoryAwareExample",BeanFactoryAwareExample.class);
        System.out.println(beanFactoryAwareExample);
        ApplicationContextAwareExample A=context.getBean("applicationContextAwareExample",ApplicationContextAwareExample.class);
        System.out.println(A);
    }
}
