package com.xiaoer.day04.persontest;

public class PersonTest
{
    public static void main(String[] args) {
        Person p1 = new Person();
        //age 封装，不能直接调用
//        p1.age = 10;
        //给age赋值
        p1.setAge(10);
        System.out.println("age = " + p1.getAge());

        p1.sex = 1;
        p1.study();
        p1.showAge();
        p1.addAge(2);
        p1.showAge();

        Person p2 = new Person("胖大海");
        System.out.println(p2.name);

    }
}
