package com.xiaoer.homework.interface_exercise.cise06;

public class Taxi extends Seater implements IRun {

    public Taxi(String brand) {
        super(brand);
    }

    @Override
    public void run() {
        System.out.println("出租车开始跑了");
    }
}
