package com.atxiao2._02_common_class._02_time_class_test;

import org.junit.Test;

import java.util.Date;

/**
 * 1.System类中的currentTimeMillis()方法
 *      currentTimeMillis() 获取当前时间到1970年1月1日0点0分的时间差，单位毫秒（时间戳 ）
 *
 * 2.date类
 *  （1） java.util.Date类
 *      使用构造器创建对象：
 *             无参构造器：创建一个当前时间对应的date对象
 *             带参构造 ：器创建指定时间的date对象4
 *  （2） java.sql.Date类（是java.util.Date类的子类）
 *              带参构造 ：器创建指定时间的date对象
 */
public class TimeClassTest {

    @Test //java.util.Date
    public void test1(){
        //使用无参构造器创建java.util.Date对象
        Date date = new Date();
        // System.out.println(date.toString());
        System.out.println(date);// 当前 星期 月 日 时间 时区 年

        System.out.println(date.getTime()); //获取当前时间戳1642849139446
        // 使用带参构造器创建指定时间的date对象
        Date date1 = new Date(1642849139446l);
        System.out.println(date1);
    }

    @Test // java.sql.Date
    public void test2(){
        // Date date = new Date(); //两个Date同名
        java.sql.Date date = new java.sql.Date(1642849139446l);

        //java.util.Date 转 java.sql.Date
        java.sql.Date date1 = new java.sql.Date(new Date().getTime());
        //java.sql.Date --> java.util.Date
        Date date2 = date1;

    }

    @Test //currentTimeMillis()
    public void test(){
        System.out.println(System.currentTimeMillis());//1642576506841ms
    }
}
