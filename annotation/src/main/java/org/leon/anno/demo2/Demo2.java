package org.leon.anno.demo2;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: liyang27
 * @Date: 2020/8/6 10:40
 * @Description:
 *把对象注入到方法上
 * 其实我们是这样把对象注入到方法中的：
 *
 * 得到想要类中注入的属性
 *
 * 得到该属性的对象
 *
 * 得到属性对应的写方法
 *
 * 通过写方法得到注解
 *
 * 获取注解详细的信息
 *
 * 将注解的信息注入到对象上
 *
 * 调用属性写方法，将已填充数据的对象注入到方法中
 */
public class Demo2 {
    public static void main(String[] args) throws IntrospectionException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.使用内省【后边需要得到属性的写方法】，得到想要注入的属性
        PropertyDescriptor descriptor = new PropertyDescriptor("person",PersonDao.class);
        //2.得到要想注入属性的具体对象
        Person person = (Person)descriptor.getPropertyType().getConstructor().newInstance();
        //3.得到该属性的写方法【setPerson()】
        Method method = descriptor.getWriteMethod();
        //4.得到写方法的注解
        Annotation annotation = method.getAnnotation(InjectPerson.class);
        //5.得到注解上的信息【注解的成员变量就是用方法来定义的】
        Method[] methods = annotation.getClass().getMethods();
        //6.将注解上的信息填充到person对象上
        for(Method m:methods){
            //得到注解上属性的名字【age或name】
            String name=m.getName();
            //看看Person对象有没有与之对应的方法【setAge(),setName()】
            try{
                //6.1这里假设：有与之对应的写方法，得到写方法
                PropertyDescriptor descriptor1 = new PropertyDescriptor(name,Person.class);
                Method method1 = descriptor1.getWriteMethod();
                //得到注解中的值
                Object o = m.invoke(annotation,null);
                //调用Person对象的setter方法，将注解上的值设置进去
                method1.invoke(person,o);
            }catch (Exception e){
                //6.2 Person对象没有与之对应的方法，会跳到catch来。我们要让它继续遍历注解就好了
                continue;
            }
        }
        PersonDao personDao=new PersonDao();
        method.invoke(personDao,person);
        System.out.println(personDao.getPerson().getUserName());
        System.out.println(personDao.getPerson().getAge());
    }
}
