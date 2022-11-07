package com.xiaoer.homework.oop_exercise.student;

public class StudentTest
{
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("高某");
        stu.setAge(50);
        System.out.println(stu.getName());
        System.out.println(stu.getAge());

        Student stu1 = new Student("高某",18);
        stu1.setAge(21);
        System.out.println(stu1.getName());
        System.out.println(stu1.getAge());

        System.out.println(stu.equals(stu1));
        System.out.println(stu);
        System.out.println(stu1);
    }
}
