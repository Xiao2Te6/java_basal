package com.xiaoer.homework.interface_exercise.cise06;

public class Ship extends Seater implements ISwim {

    public Ship(String brand) {
        super(brand);
    }

    @Override
    public void swim() {
        System.out.println("船舶开始在海洋中漂泊了");
    }
}
