package com.xiaoer.day04.persontest;

public class Person
{
    String name;
    private int age;
    /**
     * 1为男，0为女
     */
    int sex;
    // 空参构造器
    public  Person(){
        age = 0;
        System.out.println("欢迎使用person");
    }
    //带参构造器
    public Person(String str){
        name = str;
    }

    public void  study(){
        System.out.println("studying");
    }

    public void showAge(){
        System.out.println(age);
    }

    //设置age的方法
    public void setAge(int a) {
        if (a <= 0){
            age = 1;//异常情况不允许设置
            return;
        }else {
        age = a;
        }
    }
    //获取age的方法
    public int getAge(){
        return age;
    }

    public int addAge(int add){
        age += add;
        return age;
    }
        
}
