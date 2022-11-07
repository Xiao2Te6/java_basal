package com.xiaoer.homework.interface_exercise.cise02;

public class TestDemo
{
    public static void main(String[] args) {

        //当编译类型和运行类型不一样时就会产生多态
        //编译时类型↓   //运行时类型↓
        Animal animal = new Dog();
        animal.shout();
    }
}
