package com.xiaoer.wrapper_test;

import org.junit.Test;

import java.util.Scanner;
import java.util.Vector;

/**
 * 包装类
 */
public class WrapperTest {
    public static void main(String[] args) {
        WrapperTest test1 = new WrapperTest();
        test1.wrapperTestDome();
    }

    @Test
    public void integerTest(){
//        Integer integer = new Integer(1);
//        Integer integer1 = new Integer(1);
//        System.out.println(integer == integer1);//false

        Integer integer2 = 1;
        Integer integer3 = 1;
        System.out.println(integer2 == integer3);//true(Integer类会创建一个-128到127的IntegerCache[]，如果不new新的
                                                // Integer对象，会调用数组cache中的数据就会是同一个对象)
        Integer integer4 = 128;
        Integer integer5 = 128;
        System.out.println(integer4 == integer5);//false（超过了数组cache就会重新new新的对象）
    }

    @Test
    public void wrapperTest(){
        //Integer转String类型
        Integer num = 34;
        String strNum = String.valueOf(num);
        System.out.println(strNum);

        //String 转 Integer类型
        String str = new String();
        str = "12234";
        int i = Integer.parseInt(str);
        System.out.println(i);

        //Sring转double类型
        double v = Double.parseDouble(str);
        System.out.println(v);
    }

    @Test
    public void wrapperTestDome(){
        Scanner scan = new Scanner(System.in);
        Vector<Integer> scores = new Vector<>();
        int maxScore = 0;
        for (int i=1;; i++){
            System.out.println("请输入第" + i + "个学生成绩（输入负数结束）：");
            Integer intScore = scan.nextInt();
             if (intScore < 0 ){
                 break;
             }else {
                 scores.addElement(intScore);
                 if (intScore > maxScore){
                     maxScore = intScore;
                 }
             }
        }
        for (int i = 0; i < scores.size(); i++){
            if (maxScore - scores.get(i) < 10){
                System.out.println("第" + i+1 +"个学生的成绩为：A");
            }else if (maxScore - scores.get(i) < 20){
                System.out.println("第" + i+1 +"个学生的成绩为：B");
            }else if (maxScore - scores.get(i) < 20) {
                System.out.println("第" + i+1 + "个学生的成绩为：C");
            }else {
                System.out.println("第" + i+1 + "个学生的成绩为：D");
            }
        }


    }
}
