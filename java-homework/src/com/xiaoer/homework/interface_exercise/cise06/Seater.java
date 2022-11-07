package com.xiaoer.homework.interface_exercise.cise06;

/**
 * 各交通工具都有品牌(brand)字段和载客行为（manned）。
 */
public class Seater {
    private String brand;

    public Seater() {
    }

    public Seater(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void manned(){
        System.out.println("我是"+ brand + "有载客行为");
    }
}
