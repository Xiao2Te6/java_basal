package com.xiaoer.keywords_test.abstact_keywords;

public class TestDemo {
    public static void main(String[] args) {
        //多态
        Person student = new Student();
        student.say();

        Student student1 = (Student) student;

        //创建匿名子类对象(利用父类构造器临时造一个没有名字的子类)
        Person person = new Person(){

            @Override
            public void say() {
                System.out.println("给爷爬");
            }
        };
        person.say();

        //创建匿名子类的匿名对象
        student1.say(new Person() {
            @Override
            public void say() {
                System.out.println("爬快点");
            }
        });

    }
}
