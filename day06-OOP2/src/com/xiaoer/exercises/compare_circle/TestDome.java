package com.xiaoer.exercises.compare_circle;

public class TestDome {
    public static void main(String[] args) {
        CompareableCircle circle0 = new CompareableCircle(3.2);
        CompareableCircle circle1 = new CompareableCircle(2.2);

        double compareNum = circle0.compareTo(circle1);
        if (compareNum == 0){
            System.out.println("两个对象相等");
        }else if (compareNum < 0){
            System.out.println("circle1大");
        }else {
            System.out.println("circle0大");
        }

    }
}
