package com.xiaoer.homework.oop_exercise.extende_demo;

public class Student  extends Person{
    private int  studentid;

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void  study(){
         System.out.println(getName() + "在学习 ");
     }

    public void rest(){
        System.out.println(getName() + "从来不休息");
    }
    public void toRest(){
        super.rest();
    }
}
