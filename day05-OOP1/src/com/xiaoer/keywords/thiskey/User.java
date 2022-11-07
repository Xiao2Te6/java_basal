package com.xiaoer.keywords.thiskey;

public class User extends Person
{

    public User() {
        System.out.println("嘿嘿");
    }

    public User(String name, int age) {
       super(name, age);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public int getAge() {
        return super.getAge();
    }

    public void setAge(int age) {
        super.setAge(age);
    }
}
