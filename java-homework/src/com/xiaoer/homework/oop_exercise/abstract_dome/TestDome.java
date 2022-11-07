package com.xiaoer.homework.oop_exercise.abstract_dome;

public class TestDome
{
    public static void main(String[] args) {

        Circle circle = new Circle(1.00);
        System.out.println(circle.area());
        System.out.println();

        Rectangle rectangle = new Rectangle(1.0,2.0);
        System.out.println(rectangle.area());
    }
}
