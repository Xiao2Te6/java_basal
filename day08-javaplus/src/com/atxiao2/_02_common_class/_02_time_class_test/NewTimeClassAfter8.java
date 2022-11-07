package com.atxiao2._02_common_class._02_time_class_test;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * Java8过后的新的关于时间的API
 */
public class NewTimeClassAfter8 {

    /**
     *  localDate、localTime、locDateTime的使用何常用方法
     *    localDateTime使用频率较高 这三个类的常用方法差不多
     *    类似于Calendar类
     */
    @Test
    public void localDateTimeTest(){
        //实例化方式，获取对象
        LocalDateTime now = LocalDateTime.now();//获取当前时间的对象
        System.out.println(now);

        LocalDateTime time = LocalDateTime.of(2022, 3, 16, 20, 22);//获取指定时间对象
        System.out.println(time);

        //常用方法 (不可变性)
        //getXxx()获取对应属性值
        int dayOfMonth = time.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        //withXxx（）设置相关属性值
        LocalDateTime timeAfterWith = time.withHour(21);
        System.out.println("timeAfterWith = " + timeAfterWith);

        //plusXxx() 增加相关属性值
        LocalDateTime timeAfterPlus = time.plusYears(1);
        System.out.println("timeAfterPlus = " + timeAfterPlus);

        //minusXxx  减少相关属性值
        LocalDateTime timeAfterMinus = time.minusMonths(1);
        System.out.println("timeAfterMinus = " + timeAfterMinus);
    }

    /**
     * Instant （瞬时）类的使用
     *      类似 Date类
     */
    @Test
    public void instantTest(){
        //实例化（获取对象）
        // now()
        Instant nowTime = Instant.now();//获取当前本初子午线时间
        System.out.println(nowTime);//2022-03-16T12:37:35.567426400Z 差8小时
        OffsetDateTime offsetDateTime = nowTime.atOffset(ZoneOffset.ofHours(8));//添加时间偏移量
        System.out.println("offsetDateTime = " + offsetDateTime); //2022-03-16T20:40:08.376969800+08:00

        //ofEpochMilli()
        Instant instant = Instant.ofEpochMilli(1647434598999L);//获取对应时间戳的instant对象
        System.out.println("instant = " + instant);

        //常用方法
        //toEpochMilli() 获取时间戳
        long l = nowTime.toEpochMilli();// 获取1970年1月1日0：00到当前时间的毫秒数
        System.out.println("l = " + l);
    }

    /**
     * DateTimeFormatter类（格式化日期、时间）
     *      类似于SimpleDateFormatter类
     */
    @Test
    public void dateTimeFormatterTest(){
        //实例化（获取对象）
        //方式一：预定义的标准格式 如 ISO_DATE_TIME 、ISO_LOCAL_DATE_TIME 等等
        DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //方式二：本地化相关格式 ofLocalizedDateTime（）
             //  适用参数如  FormatStyle.FULL; FormatStyle.SHORT; FormatStyle.LONG等等
        DateTimeFormatter format1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);//适用于localDatedTime对象
        DateTimeFormatter format2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM); //适用于localDate对象

        //方式三 ：使用自定义方式（使用较多）
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");


        //常用方法
        //格式化 日期对象--> 字符串
        String nowTime = format.format(LocalDateTime.now());
        System.out.println("nowTime = " + nowTime); //2022-03-16T21:14:32.0199823

        //解析  字符串--> 日期对象
        TemporalAccessor parse = format.parse("2022-03-16T21:14:32.0199823");
        System.out.println("parse = " + parse); //{},ISO resolved to 2022-03-16T21:14:32.019982300
    }
}
