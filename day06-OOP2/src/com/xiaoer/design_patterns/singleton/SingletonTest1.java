package com.xiaoer.design_patterns.singleton;

/**
 * 单例设计模式：采取一定的方式保证整个系统中，对某个类只能存在一个实例对象
 */
public class SingletonTest1 {
    public static void main(String[] args) {

        A a = A.getInstance();
        A a1 = A.getInstance();
        System.out.println(a == a1);

        System.out.println("-------------------------");

        B b = B.getInstance();
        B b1 = B.getInstance();
        System.out.println(b == b1);

    }
}

/**
 * 饿汉式单例设计模式（一上来就造好对象）
 * 优势：线程安全
 * 劣势：生命周期过长，占用内存
 */
class A {
    //1.私有化构造器
    private A() {

    }
    //2.在内内部声明类的私有对象并初始化
    //3.因为静态方法不能调用非静态对象，所以将对象私有化
    private static A instance = new A();

    //3.由于构造器是有化，外部不能创建对象，无法调用方法，所以创建静态get方法获取类的对象
    public static A getInstance() {
        return instance;
    }
}

/**
 * 懒汉式单例设计模式（啥时候用啥时候造对象）
 * 优势：延迟对象的创建
 * 劣势：目前写法线程不安全
 */
class B {
    //1.私有化构造器
    private B() {

    }
    //2.在内内部声明类的私有对象不初始化
    //3.因为静态方法不能调用非静态对象，所以将对象私有化
    private static B instance = null;

    //3.由于构造器是有化，外部不能创建对象，无法调用方法，所以创建静态get方法获取类的对象
    public static B  getInstance(){
        //判断是否初始化过对象，保证只new一次
        if (instance == null){

            instance = new B();
        }
        return instance;
    }
}
