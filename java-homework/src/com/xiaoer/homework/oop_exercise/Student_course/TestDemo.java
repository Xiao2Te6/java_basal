package com.xiaoer.homework.oop_exercise.Student_course;

public class TestDemo
{
    public static void main(String[] args) {
        Course math = new Course("数学", 88);
        Student student = new Student("黄晓明", 18, math);
        student.inFor();
        System.out.println("------------------------------------");
        Course chinese = new Course("语文", 90);
        Student student1 = new Student("王飞", 15, chinese);
        student1.inFor();
    }
}
