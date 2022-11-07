package com.xiaoer.homework.oop_exercise.abstract_dome;

public class Rectangle extends AbstractGraph{
    private double leng;
    private double wide;

    public Rectangle() {
    }

    public Rectangle(double leng, double wide) {
        this.leng = leng;
        this.wide = wide;
    }

    public double getLeng() {
        return leng;
    }

    public void setLeng(double leng) {
        this.leng = leng;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public double area(){
        return wide * leng;
    }
}
