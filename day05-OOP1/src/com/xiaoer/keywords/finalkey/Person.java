package com.xiaoer.keywords.finalkey;

import org.w3c.dom.ls.LSOutput;

//被final修饰的类不能被继承
public /*final*/ class Person
{
    private String name;
    private  int age;

    public Person() {
        System.out.println("代码块2");
    }

    {
        System.out.println("代码块1");
    }
     static {
         System.out.println("静态代码块1");
     }
     static {
         System.out.println("静态代码块2");
     }

    // 被final修饰不能被重写
    public /* final */void say(){
        System.out.println("sb");
    }
}
