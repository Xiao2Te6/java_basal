package com.xiaoer.keywords_test.abstact_keywords;

public class Student extends Person {
    @Override
    public void say() {
        System.out.println("你放屁");
    }

    public void say(Person person){
        person.say();
    }
}
