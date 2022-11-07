package com.xiaoer.homework.interface_exercise.cise04and05;

public class TestDemo
{
    public static void main(String[] args) {
        MotherBoard motherBoard = new MotherBoard();
        motherBoard.pLugin(new Mouse());

        //instanceof演示
        Keyboard keyboard = new Keyboard();
        System.out.println(keyboard instanceof IUsbable);
        //类型强制转换
        IUsbable a = new Keyboard();
        Keyboard b = (Keyboard) a;
    }
}
