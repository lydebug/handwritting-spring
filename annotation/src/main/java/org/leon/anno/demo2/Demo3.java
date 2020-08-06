package org.leon.anno.demo2;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: liyang27
 * @Date: 2020/8/6 11:13
 * @Description:
 */
public class Demo3 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.得到想要注入的属性
        Field field = PersonDao.class.getDeclaredField("person");
        //2.得到属性的具体对象
        Person person = (Person) field.getType().getConstructor().newInstance();
        //3.得到属性上的注解
        Annotation annotation = field.getAnnotation(InjectPerson.class);
        //4.得到注解的属性【注解上的属性使用方法来表示的】
        Method[] methods = annotation.getClass().getMethods();
        //5.将注入的属性填充到person对象上
        for (Method m:methods){
            //5.1得到注解属性的名字
            String name = m.getName();
            //查看一下Person对象上有没有与之对应的写方法
            try{
                //如果有
                PropertyDescriptor descriptor = new PropertyDescriptor(name,Person.class);
                //得到Person对象上的写方法
                Method method=descriptor.getWriteMethod();
                //得到注解上的值
                Object o = m.invoke(annotation,null);
                //填充person对象
                method.invoke(person,o);
            } catch (IntrospectionException e) {
                continue;
            }
        }
        //循环完之后，person就已经填充好数据了
        //6.把person对象设置到PersonDao中
        PersonDao personDao = new PersonDao();
        field.setAccessible(true);
        field.set(personDao,person);
        System.out.println(personDao.getPerson());
    }
}
