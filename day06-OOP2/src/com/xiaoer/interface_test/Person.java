package com.xiaoer.interface_test;

/**
 * 实现类可以实现多个接口
 */
public class Person implements IAmphibiable /*,ISwimable,IWalkable*/{
    @Override
    public void Swim() {
        System.out.println(" 救命，救命");
    }

    @Override
    public void Walk() {
        System.out.println("噔，噔，噔，噔，噔，噔，噔，噔");
    }

    @Override
    public void run() {
        System.out.println("咻咻咻");
    }
}
