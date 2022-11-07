package com.xiaoer.homework.oop_exercise.phone;

public class Phone
{
    private String name;
    private double prices;
    private float wight;
    private String color;
    private int ramSize;

    public Phone() {
    }

    public Phone(String name, double prices, float wight, String color, int ramSize) {
        this.name = name;
        this.prices = prices;
        this.wight = wight;
        this.color = color;
        this.ramSize = ramSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public float getWight() {
        return wight;
    }

    public void setWight(float wight) {
        this.wight = wight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void showInfo(){
        System.out.println("名称： " + name);
        System.out.println("价格： " + prices);
        System.out.println("重量： " + wight);
        System.out.println("颜色： " + color);
        System.out.println("内存： " + ramSize);
    }
}
