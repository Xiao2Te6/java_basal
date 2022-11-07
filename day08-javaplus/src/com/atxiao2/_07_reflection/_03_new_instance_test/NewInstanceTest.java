package com.atxiao2._07_reflection._03_new_instance_test;

import org.junit.Test;

/**
 * @author : XiaoEr
 * @date : 2022/10/27
 * <p>
 * newInstance(): 返回运行时类的对象（默认调用空参构造器，且需要权限够用））
 * 在java9的时候已过时：推荐使用 clazz.getDeclaredConstructor().newInstance()
 */
public class NewInstanceTest {
    @Test
    public void test() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();//直接使用clazz.newInstance()会默认使用运行时类中的空参构造器
        System.out.println("person = " + person);

        Person person1 = personClass.getDeclaredConstructor().newInstance();
        System.out.println("person1 = " + person1);
    }

    /**
     * 使用场景演示：
     * 创建一个可以获取指定类对象的方法
     */
    @Test
    public void test1() throws Exception {
        Object instance = getInstance("com.atxiao2._07_reflection._03_new_instance_test.Person");
        System.out.println(instance);
    }

    public Object getInstance(String path) throws Exception {
        Class aClass = Class.forName(path);
        Object o = aClass.getDeclaredConstructor().newInstance();
        return o;
    }
}