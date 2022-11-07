package com.xiaoer.homework.keywords_exercise.dog01;

/**
 * 定义一个狗类Dog，在狗类中定义静态字段和静态方法（属于类的成员），
 * 定义非静态字段和非静态方法（属于对象的成员），
 * 并在StaticDemo方法中测试调用狗类中的方法和字符
 */
public class Dog {
    static String name;
    int age;

    public void eat(){
        System.out.println("吃");
    }

    public static void run(){
        System.out.println("跑");
    }
}
