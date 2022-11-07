package com.xiaoer.keywords_test.static_keywords;

public class AreaDemo
{
    public static void main(String[] args) {
        Area area = new Area(2);
        Area area1 = new Area(3);

        System.out.println(Area.getCount());
        System.out.println("area.getId() = " + area.getId());
        System.out.println("area1.getId() = " + area1.getId());
    }
}
