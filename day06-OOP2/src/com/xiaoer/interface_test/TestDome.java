package com.xiaoer.interface_test;

public class TestDome
{
    public static void main(String[] args) {

        //1.创建接口实现类的一般对象
        Person person = new Person();
        person.Swim();
        person.Walk();
        person.run();
        System.out.println();

        //2.创建接口实现类的匿名对象
        new Person().run();
        System.out.println();

        //3.创建匿名接口实现类的一般对象
        IAmphibiable iAmphibiable = new IAmphibiable() {
            @Override
            public void Walk() {
                System.out.println("跑不动");
            }
            @Override
            public void Swim() {
            }
            @Override
            public void run() {

            }
        };
        iAmphibiable.Walk();
        System.out.println();

        //4.创建匿名接口实现类的匿名对象
        new IAmphibiable(){
            @Override
            public void Walk() {
                System.out.println("aaaa");
            }
            @Override
            public void Swim() {
            }
            @Override
            public void run() {
            }
        }.Walk();

    }
}
