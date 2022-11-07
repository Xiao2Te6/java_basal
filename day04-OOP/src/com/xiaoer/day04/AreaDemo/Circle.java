package com.xiaoer.day04.AreaDemo;

class Circle extends AbstractGraph {
    double radius;

    public double getArea(){
        double area = Math.PI * radius * radius;
        return area;
    }
}
