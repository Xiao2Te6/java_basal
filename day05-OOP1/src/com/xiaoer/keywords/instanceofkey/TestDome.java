package com.xiaoer.keywords.instanceofkey;

public class TestDome {
    public static void main(String[] args) {
        Person p1 = new Man();
        Man man = new Man();
        Woman woman = new Woman();
        if (p1 instanceof  Man){
            System.out.println("is man");
        }
        if (p1 instanceof Woman){
            System.out.println("is Woman");
        }
        if (p1 instanceof Person){
            System.out.println("is person");
        }
        if (p1 instanceof Object){
            System.out.println("is object");
        }

    }
}
