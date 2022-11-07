package com.xiaoer.homework.oop_exercise.student1;

public class StudentTest
{
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        student.setGender("女");
        student.setAge(18);
        student.setEnScore(90);
        student.setMaScore(135);
        student.setCnScore(105);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getGender());
        System.out.println(student.getEnScore());
        System.out.println(student.getMaScore());
        System.out.println(student.getCnScore());
        System.out.println("------------------------------------------");

        Student student1 = new Student("李四",20, "女",130,100,125);
        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getGender());
        System.out.println(student1.getEnScore());
        System.out.println(student1.getMaScore());
        System.out.println(student1.getCnScore());

    }
}
