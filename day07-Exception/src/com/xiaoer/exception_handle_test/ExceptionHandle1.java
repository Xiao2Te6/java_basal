package com.xiaoer.exception_handle_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常处理方式二：throws + 异常
 * throws,meiyou 
 */
public class ExceptionHandle1 {

    public static void main(String[] args) {
        ExceptionHandle1 handel1 = new ExceptionHandle1();
        handel1.method_3();
    }

    public void method_3(){
        try {
            method_2();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void method_2() throws IOException {
        method_1();
    }

    public void method_1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        //文件找不到异常（FileNotFoundException）
        FileInputStream fileInputStream = new FileInputStream(file);

        int data = fileInputStream.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fileInputStream.read();
        }
        fileInputStream.close();
        System.out.println("哈哈哈");
    }
}

