package com.xiaoer.homework.keywords_exercise.final02;

/**
 * final修饰的类：表示最终的类, 该类不能再有子类
 * final修饰的方法：最终的方法, 该方法不能被子类覆盖
 * final修饰的变量：表示常量，该变量只能赋值一次，不能再重新赋值。
 * 基本数据类型：表示的值不能改变
 * 引用数据类型：所引用的地址值不能改变
 */
public class FinalDemo
{
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);
//        student.name = "ab";
//        student.age  = 10;
    }
}
