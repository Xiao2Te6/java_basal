package com.atxiao2._07_reflection._04_get_class_stracture;

import com.atxiao2._07_reflection._04_get_class_stracture.person.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : XiaoEr
 * @date : 2022/10/31
 *
 * 获取运行时类中的其他结构
 *
 * ConstructorReference
 * Superclass
 * GenericSuperclass
 */
public class GetOtherTest {

    //获取构造器 (获取构造器结构与获取方法具体结构类似)
    public void test(){
        Class<Person> clazz = Person.class;
        //获取运行时类pulic修饰的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println("c = " + c);
        }

        //获取运行时类所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> dc : declaredConstructors) {
            System.out.println("dc = " + dc);
        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;

        //获取运行时类的父类  getSuperClass()
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println("superclass = " + superclass);

        //获取带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println("genericSuperclass = " + genericSuperclass);

        //获取带泛型父类的泛型 （先强转为ParameterizedType 在获取泛型参数）
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型参数：getActualArgument()
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            Class aa = (Class) actualTypeArgument;
            System.out.println("actualTypeArgument = " + aa.getName());
        }
    }

    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println("i = " + i);
        }

        //获取运行时类父类实现的接口
        for (Class<?> si : clazz.getSuperclass().getInterfaces()) {
            System.out.println("si = " + si);
        }
    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test4(){
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println("aPackage = " + aPackage);
    }

    /**
     * 获取运行时类的注解
     */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        for (Annotation da : declaredAnnotations) {
            System.out.println("da = " + da);
        }
    }

}