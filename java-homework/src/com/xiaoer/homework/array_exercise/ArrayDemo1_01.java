package com.xiaoer.homework.array_exercise;

public class ArrayDemo1_01 {
//    （1）先定义后初始化数组（不能使用简写方式）    
//    （2）定义数组，同时初始化
//    （3）打印数组长度
//    （4）数组赋值为空，并演示空指针错误
public static void main(String[] args) {
    int[] arr;
    arr= new int[]{1,2,3};
    
    int[] arr1 = new int[]{1,2,3};
    for (int i = 0; i < arr.length; i++){
        System.out.println(arr[i]);
    }
    
    arr = null;
    System.out.println("arr[1] = " + arr[1]);
    
}
}
