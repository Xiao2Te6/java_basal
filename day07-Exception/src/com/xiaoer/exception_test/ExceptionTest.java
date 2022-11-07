package com.xiaoer.exception_test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 * Exception(例外，异常)
 */
public class ExceptionTest {

    //运行时异常
    @Test
    public void nullPointerExceptionTest() {
        //空指针异常
        String str = new String();
        str = null;
        System.out.println(str.charAt(0));
    }

    @Test
    public void indexOutBoundsExceptionTest() {
        //数组角标越界(ArrayIndexOutOfBoundsException)
        int[] arr = new int[0];
        System.out.println(arr[1]);

        //字符串角标越界(StringIndexOutOfBoundsException)
        String str = new String();
        str = "abc";
        System.out.println(str.charAt(3));
    }

    @Test
    public void classCastExceptionTest() {
        //类型转换异常（ClassCastException）deal with
        Date date = new Date();
        Object obj = (Object) date;
        String str = (String) obj;
    }

    @Test
    public void numberFormatExceptionTest() {
        //数值格式错误异常（NumberFormatException）
        String str = "abc";
        Integer intNum = Integer.valueOf(str);
        System.out.println(intNum);
    }

    @Test
    public void inputMismatchExceptionTest() {
        // 输入格式异常（InputMismatchException）
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt());
        scanner.close();
    }

    @Test
    public void arithmeticExceptionTest() {
        //算数异常（ArithmeticException）
        int i = 1;
        int j = 0;
        System.out.println(i / j);
    }

    //编译时异常
    @Test
    public void runTimeExceptionTest() {
//        File file = new File("hello.txt");
//        //文件找不到异常（FileNotFoundException）
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        int data = fileInputStream.read();
//        while (data != -1) {
//            System.out.println((char) data);
//            data = fileInputStream.read();
//        }
//        fileInputStream.close();
    }
}
