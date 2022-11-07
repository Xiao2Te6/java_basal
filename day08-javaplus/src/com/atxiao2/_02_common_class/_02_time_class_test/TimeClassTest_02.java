package com.atxiao2._02_common_class._02_time_class_test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  SimpleDateFormat（简单的时间格式化）
 *      date对象 --> 格式化为固定格式字符串
 *              使用format（）方法
 *      固定格式字符串 --> date对象
 *              使用 parse（）方法
 *
 */
public class TimeClassTest_02 {

    @Test
    public  void SimpleDateFormatTest() throws ParseException {
        //无参构造器初始化(创建默认时间解析格式的SimpleDateFormat对象)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        Date date = new Date();
        System.out.println(date);

        //格式成为成默认格式
        String formatDate = simpleDateFormat.format(date);
        System.out.println(formatDate);//  2022/2/18 下午6:27

        //使用parse（）方法将格式化后得字符串解析成 Date对象
        Date parseDate = simpleDateFormat.parse(formatDate);
        System.out.println(parseDate);

    }

    @Test
    public  void SimpleDateFormatTest02() throws ParseException {
        // 带参构造器初始化(传入时间格式，创建指定格式的SimpleDateFormat对象)
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("yy-MM-dd"); //（格式字符串对应字符参考文档）

        String str = "2022-2-22";

        //使用parse（）方法将固定格式的字符串解析成 Date对象
        Date parseDate = simpleDateFormat.parse(str);
        System.out.println(parseDate); //Tue Feb 22 00:00:00 CST 2022

        //使用format将解析后的date对象格式化
        String formatDate = simpleDateFormat.format(parseDate);
        System.out.println(formatDate); //  22-02-22

    }

    @Test
    public void exercise() throws ParseException {
        // 将字符串“2022-02-22” 转换成java.sql.Date的对象
        String str = "022-02-22";
        //1.创建对应格式的SimpleDateFormat对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //2.将字符串解析为java.util.Date对象
        Date parse = simpleDateFormat.parse(str);
        //3.将java.util.Date对象转换为 java.sql.Date对象
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date.toString());
    }
}
