package com.atxiao2._02_common_class._02_time_class_test;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.DAY_OF_MONTH;

public class TimeClassTest_03 {
    /**
     * Calendar(日历类)
     */
    @Test
    public void calendarTest(){
        //实例化
        GregorianCalendar gregorianCalendar = new GregorianCalendar(); //方法一：创建子类GregorianCalendar类的对象
        Calendar calendar = Calendar.getInstance();//方法二： 调用 getInstance（）获取子类GregorianCalendar子类对象
        // System.out.println(gregorianCalendar.equals(calendar));
        System.out.println(calendar);

        // 常用方法
        // get
        System.out.println(calendar.get(DAY_OF_MONTH)); //14
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); // 73
        // set (可变性 : 改变原对象的值)
        calendar.set(DAY_OF_MONTH,10);//设置当前天数为10
        System.out.println(calendar.get(DAY_OF_MONTH)); //10
        // add
        calendar.add(DAY_OF_MONTH,5);//当前天数加5 减加-5
        System.out.println(calendar.get(DAY_OF_MONTH)); //15
        // getTime
        Date time = calendar.getTime();
        System.out.println(time);
        // setTime
        calendar.setTime(new Date());
        System.out.println(calendar.get(DAY_OF_MONTH));
    }
}
