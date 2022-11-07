package com.xiaoer.day04.cat;

public class CatTest
{
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.age = 30;
        cat.shout();

        Cat cat1 = new Cat("高某",60);
        cat1.shout();
    }
}
