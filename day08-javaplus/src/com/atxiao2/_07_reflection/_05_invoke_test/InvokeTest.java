package com.atxiao2._07_reflection._05_invoke_test;

import com.atxiao2._07_reflection._04_get_class_stracture.person.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : XiaoEr
 * @date : 2022/10/31
 */
public class InvokeTest {

    /**
     * 通过反射获取指定属性并赋值
     */
    @Test
    public void test() throws Exception {
        Class<Person> clazz = Person.class;

        //方式一： 使用getFiled获取public修饰的值
        //1.通过反射创建Person类的对像
        Person person = clazz.getDeclaredConstructor().newInstance();

        //2.获取直段
        Field name = clazz.getField("name");
        //3.指明对象并赋值
        name.set(person, "小黄");
        //4.获取值
        Object o = name.get(person);
        System.out.println(o);

        //方式二（常用）
        Field age = clazz.getDeclaredField("age");
        //将私有属性设置为可访问的
        age.setAccessible(true);
        age.set(person,18);
        Object ageValue = age.get(person);
        System.out.println("age = " + ageValue);
    }

    /**
     * 获取指定方法并调用
     */
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.getDeclaredConstructor().newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        //invoke(object，parameterType):使用指定对象object调用方法，并将返回被调用方法的返回值(如果该方法没有返回值则会返回null)
        Object returnValue = show.invoke(person, "haha");
        System.out.println(returnValue);

        //静态方法的调用（指定对象为null即可）
        Method say = clazz.getDeclaredMethod("say");
        say.setAccessible(true);
        Object invoke = say.invoke(null);
        System.out.println(invoke);
    }

    /**
     * 调用指定构造器
     */
    @Test
    public void test3() throws Exception {
        Class<Person> clazz = Person.class;
        //获取空参构造器
        Constructor<Person> constructor = clazz.getDeclaredConstructor();


        //获取全参数构造器(不常用)
        Constructor<Person> constructor1 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        Person person = constructor1.newInstance("小白", 18, "爱睡觉");
        System.out.println(person);
    }
}
