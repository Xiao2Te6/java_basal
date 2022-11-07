package com.xiaoer.homework.oop_exercise.abstract_dome;

public class Circle extends AbstractGraph
{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }


}
