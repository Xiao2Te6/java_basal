package com.xiaoer.homework.keywords_exercise.dog01;

public class DogTest
{
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog.name = "苟";
        dog.age = 10;
        dog.eat();
        Dog.run();
    }
}
