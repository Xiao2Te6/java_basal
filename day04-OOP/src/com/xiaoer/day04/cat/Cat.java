package com.xiaoer.day04.cat;

public class Cat
{
    int age;
    String name;

    public  Cat(){
        name = "胖大海";
    }
    public Cat(String name1, int age1){
        age = age1;
        name = name1;
    }
    public void shout(){
        System.out.println("小猫咪在叫。。。。");
        System.out.println("小猫咪的名字叫：" + name + "  小猫咪的年龄是" + age + "岁");

}
}
