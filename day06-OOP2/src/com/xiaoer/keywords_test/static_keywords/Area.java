package com.xiaoer.keywords_test.static_keywords;

public class Area {
    private double redius;
    private int id;
    private static int initid = 10001;
    private static int count;

    public Area() {
        id = initid++;
        count ++;
    }

    public Area(double redius) {
        this ();
        this.redius = redius;
    }

    public double findArea(double redius){
        return Math.PI * redius * redius;
    }

    public double getRedius() {
        return redius;
    }

    public void setRedius(double redius) {
        this.redius = redius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getInitid() {
        return initid;
    }

    public static void setInitid(int initid) {
        Area.initid = initid;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Area.count = count;
    }
}
