package com.xiaoer.exception_handle_test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常处理：抓抛模型
 * 过程一 “抛”：程序在正常执行过程中，一旦出现异常，就会在异常代码处生成一个
 * 对应异常的对象，并将此对象抛出，一旦异常抛出后代码就不再执行
 * 过程二 “抓”：异常处理的方式 --->  1.try-catch-finally  2.throws
 */
public class ExceptionHandle {

    @Test
    public void test1() {
        String str = "abc";
        //运行时异常处理
        try {
            Integer intNum = Integer.parseInt(str);
            System.out.println("hello 1 ");
        } catch (NumberFormatException e) {
            System.out.println("转换类型出问题了，傻逼！");
            //常用方法一：String getMessage（）
            System.out.println(e.getMessage());
            //常用方法二：printStackTrace（）
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("出问题了，傻逼！");
        }
        System.out.println("hello 2 ");
    }

    @Test
    public void test2() {
        //编译时异常处理
        FileInputStream fileInputStream = null;
        try {
            File file = new File("hello.txt");
            //文件找不到异常（FileNotFoundException）
            fileInputStream = new FileInputStream(file);
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //一般Io流的释放语句都放在finally中
            try {
                //防止出现空指针异常
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
        try {
            int a = 2, b = 0;
            System.out.println(a/b);
        }catch(ArithmeticException e){
            e.printStackTrace();
            //第二个异常出现程序被终止
            int[] arr = new int[0];
            System.out.println(arr[1]);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{//一定会执行
            System.out.println("帅啊");
        }
    }

    @Test
    public int test4(){
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            //出异常后会跳过return 1，进入catch中，所以catch中必须有return
            return 2;
        }finally{
            System.out.println("一定会执行");
        }
    }
}
