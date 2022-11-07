package com.xiaoer.interface_test;

public class Person implements ISwimable,IWalkable {
    @Override
    public void Swim() {
        System.out.println(" 救命，救命");
    }

    @Override
    public void Walk() {
        System.out.println("噔，噔，噔，噔，噔，噔，噔，噔");
    }
}
