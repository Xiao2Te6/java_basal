package com.atxiao2._02_common_class._01_string_test;

import org.junit.Test;

/**
 * String的使用
 */
public class StringTest {
    /**
     * Sting
     * 1.Final的，不可被继承
     * 2.实现了Comparable接口：可以用于比较大小
     * 3.实现了Serializable接口：字符串支持序列化
     * 4.内部定义了 final char[] value用存储字符串数据，代表不可变的字符序列，简称不可变性；
     * （字符串常量池中，不会存放同一个值）
     */
    @Test
    public void test() {
        String s1 = "abc";//字面量定义（定义在字符串常量池中）
        String s2 = "abc"; // 字符串常量池中已经有了abc，直接引用
        String s3 = new String("abc");//声明一个对象，该对象指向字符串常量池中“abc”

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false

        s2 = "hello"; //因为字符串的不可变性，所以原有给s2指定了新的值的地址值；
        System.out.println(s1 + "-->" + s2);

        String s4 = s2.replace('h', 'b');
        System.out.println(s2);//因为字符串的不可变性，所以原有给s4指定了新改值的地址值；
        System.out.println(s4);

    }

    @Test
    public void test1() {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("EE");
        String s4 = new String("EE");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3);  //false
        System.out.println(s3 == s4); //false
        System.out.println("-------------------------------------------");

        String s5 = "javaEE";
        String s6 = "java" + "EE";
        String s7 = "java" + s3; //和变量连接会生成新的对象
        String s8 = s2 + "EE";
        String s9 = s1 + s3;
        System.out.println(s5 == s6);//true
        System.out.println((s5 + s5) == (s6 + s6)); //false
        System.out.println(s5 == s7);//false
        System.out.println(s7 == s8);//false
        System.out.println(s5 == s9);//false
        System.out.println("-----------------------");

        String s10 = s9.intern();//返回值会生声明在字符串常量池中，如果字符串常量池中已存在就会直接引用
        System.out.println(s10 == s5);
        System.out.println(s10 == s9);

        /**
         * *重点
         *  1。常量与常量拼接结果在常量池。且常量池中不会出现相同内容的常量。
         *  2.只要拼接中有变量参与，结果就会在堆中
         *  3. 如果拼接结果调用了 intern（）方法，结果就在常量池中
         */
    }
}
