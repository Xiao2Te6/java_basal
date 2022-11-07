package com.xiaoer.homework.interface_exercise.cise06;

public class Airliner extends Seater implements IFlay {

    public Airliner(String brand) {
        super(brand);
    }

    @Override
    public void flay() {
        System.out.println("飞机开始飞天了");
    }
}
