package com.xiaoer.interface_test2;

public class Frog extends Animal implements IWalkable,ISwimable {
    @Override
    public void Swim() {
        System.out.println("标准的蛙泳");
    }

    @Override
    public void Walk() {
        System.out.println("走个屁");
    }
}
