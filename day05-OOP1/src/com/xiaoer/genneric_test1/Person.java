package com.xiaoer.genneric_test1;

public class Person {
    private String name;
    private String sn;
    private int age;

    public Person() {
    }

    public Person(String name, String sn, int age) {
        this.name = name;
        this.sn = sn;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
