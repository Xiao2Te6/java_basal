package com.atxiao2._02_common_class._04_other_class_test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger（不可变性，任意精度整数）当需要使用的数据特别大时使用，例如光年
 *      Integer范围 2^31-1
 *      Long范围 2^64-1
 *  常用方法：
 *          BigInteger abs():返回绝对值
 *          BigInteger add(BigInteger val): 加 this + val
 *          BigInteger subtract(BigInteger val): 减 this - val
 *          BigInteger multiply(BigInteger val): 乘 this*val
 *          BigInteger divide(BigInteger val): 除 this/val(整数相除只保留整数部分)
 *          BigInteger remainder(BigInteger val): 取模 this%val
 *          BigInteger[] divideAndRemainder(BigInteger val):返回包含 this/val和this%val两个值的数组
 *          BigInteger pow(BigInteger val): 次幂 this^val
 *
 * BigDecimal（不可变性，任意精度的有符号十进制定点数）要求数字精度比较高时使用，比如金钱
 *   常用方法：
 *          add（） subtract（） multiply（）  setScale()设置小数位数 divide（）
 */
public class BigIntegerAndBIgDecimalTest {


    @Test
    public void test(){
        BigInteger bigInteger = new BigInteger("782178182738916461286432193691273");
        System.out.println("bigInteger = " + bigInteger);

        //精度不准确出现问题
        System.out.println(0.009 + 0.001); //0.009999999999999998
        System.out.println(0.0009f + 0.0001f); //9.999999E-4

        //BigDecimal
        BigDecimal b1 = new BigDecimal("10000");  //使用BigDecimal构造器都传入String对象，可避免精度问题
        BigDecimal b2 = new BigDecimal("0.0001");
        BigDecimal b3 = new BigDecimal("3");

        //加
        System.out.println(b1.add(b2)); //10000.0001

        //减
        System.out.println(b1.subtract(b2)); //9999.9999

        //乘
        BigDecimal m1 = b1.multiply(b2); //1.0000
        System.out.println(m1);
        //设置精度为保留两位小数，并四舍五入
        BigDecimal m2 = b1.multiply(b2).setScale(2,BigDecimal.ROUND_HALF_UP); //1.00
        System.out.println(m2);

        //除 如果不设置精度就会抛算数异常
        // System.out.println(b1.divide(b3));
        System.out.println(b1.divide(b3,2,BigDecimal.ROUND_HALF_UP)); //3333.33 设置精度为保留两位小数，并四舍五入


    }
}
