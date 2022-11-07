package com.xiaoer.homework.array_exercise;

import java.util.Arrays;

public class StatisticsDemo3_12
{
    public static void main(String[] args) {
        int[] arr={1,13,45,5,0,0,16,6,0,25,4,17,6,7,0,15};
        int count = 0;
        for (int a: arr) {
            if(a != 0){
                count ++;
            }
        }
        int[] arr1 = new int[count];
        int j = 0;
        for (int b : arr){
            if (b != 0) {
                arr1[j] = b;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr1));
    }
}
