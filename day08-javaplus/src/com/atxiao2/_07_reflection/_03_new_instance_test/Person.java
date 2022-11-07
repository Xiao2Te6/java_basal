package com.atxiao2._07_reflection._03_new_instance_test;

/**
 * @author : XiaoEr
 * @date : 2022/10/9
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String show(){
        return "我叫" + this.name + ",今年" + this.age +"岁";
    }

    private String show(String say) throws NullPointerException{
        return say + "我叫" + this.name + ",今年" + this.age +"岁";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
