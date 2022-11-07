package com.xiaoer.day04.ExtendDemo;

public class Teacher extends Person {
    private int level;

    public Teacher() {

    }

    public Teacher(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void teach(){
        System.out.println(getName() + "在教课");
    }

}
