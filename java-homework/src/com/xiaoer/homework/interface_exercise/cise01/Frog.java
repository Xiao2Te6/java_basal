package com.xiaoer.homework.interface_exercise.cise01;

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
