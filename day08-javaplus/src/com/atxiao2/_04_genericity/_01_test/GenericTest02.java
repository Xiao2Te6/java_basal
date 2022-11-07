package com.atxiao2._04_genericity._01_test;

import org.junit.Test;

/**
 * @author : XiaoEr
 * @date : 2022/9/2
 *
 *  自定义泛型结构：泛型类、泛型接口、泛型方法
 *      泛型可以定义多个参数   <E,T,F>
 *      泛型类中的静态结构不能使用泛型（泛型在创建对象时确定的），泛型方法可以使用静态结构（泛型在创建方法时调用的   ）
 *      泛型不同的两个类不能相互赋值
 *      异常类不能是泛型结构
 *
 */
public class GenericTest02<T> {

    /**
     * 自定义泛型类先声明泛型，声明的泛型可以在该类中代替不确定的类，在实例化时在指明该泛型（不确定类的类型）
     */
    @Test
    public void test01(){
        Person<Integer> integerPerson = new Person<>("小红",66);
        Person<String> stringPerson = new Person<>("小红","a");

    }
    @Test
    public void test02(){
        Pupil pupil = new Pupil();
        // 子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不需要在指明泛型类型
        pupil.setScore(1);

        Undergraduate<Double> Undergraduate = new Undergraduate<>();
        Undergraduate.setScore(99.2);
    }
}

