package com.xiaoer.homework.oop_exercise.extende_demo;



public class Employee extends Person {
    private String time;

    public Employee() {

    }

    public Employee(String name, int age, String time) {
        super(name, age);
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void work(){
        System.out.println(getName() + "还在工作");
    }
}
