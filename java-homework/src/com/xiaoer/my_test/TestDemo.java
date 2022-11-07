package com.xiaoer.my_test;

import org.junit.Test;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] ints = {1, 3, 33, -1, 9, 14, 27};
        sort3(ints);
    }

    @Test
    public static void sort(int[] arr){
        //冒泡排序
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i -1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sort2(int[] arr){
        //选择排序
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i; j < arr.length - 1; j++){
                if(arr[min] > arr[j] ){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sort3(int[] arr){
        //插入排序
        for(int i = 0; i < arr.length; i++){
            for(int j = i ; j > 0; j --){
                if (arr[j - 1] > arr[j]){
                    int temp = arr[j -1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
