package com.xiaoer.interface_test2;

public class TestDemo
{
    public static void main(String[] args) {

        //声明接口类型变量
        ISwimable iSwimable = new Frog();
        iSwimable.Swim();

        //当编译类型和运行类型不一样时就会产生多态
        //编译时类型↓   //运行时类型↓
        Animal animal = new Dog();
        animal.shout();
    }
}
