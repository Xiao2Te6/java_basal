package com.xiaoer.genneric_test;

public class PointTest
{
    public static void main(String[] args) {
        Point<String> point = new Point<>("胖大海", "sb");
        Point<Integer> point1 = new Point<>(250, 41);
        System.out.println(point);
        System.out.println(point1);
    }
}
