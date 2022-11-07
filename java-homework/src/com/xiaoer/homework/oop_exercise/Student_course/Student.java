package com.xiaoer.homework.oop_exercise.Student_course;

public class Student
{
    private String name;
    private  int age;
    private Course course;

    public Student() {
    }

    public Student(String name, int age, Course course) {
        this.name = name;
        this.age = age;
        this.course = course;
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
    public void inFor(){
        System.out.println("名字： " + name);
        System.out.println("年龄： " + age);
        System.out.println("课程名字：" + course.getClassName());
        System.out.println("得分： " + course.getScore());
    }
}
