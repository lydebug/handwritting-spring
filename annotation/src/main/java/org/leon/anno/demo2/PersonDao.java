package org.leon.anno.demo2;

/**
 * @Author: liyang27
 * @Date: 2020/8/6 10:45
 * @Description:
 *
 * 使用注解将Person对象注入到setPerson()方法中，从而设置了PersonDao类的person属性
 */
public class PersonDao {

    @InjectPerson
    private Person person;

    public Person getPerson(){
        return person;
    }

    @InjectPerson
    public void setPerson(Person person){
        this.person=person;
    }
}
