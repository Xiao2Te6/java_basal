package com.xiaoer.homework.array_exercise;

import java.util.Arrays;

public class StatisticsDemo1_10
{
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int evenNumSum = 0, oddNumsum = 0;
        int[] arr1 = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evenNumSum += arr[i];
            } else {
                oddNumsum += arr[i];
            }
        }
        arr1[0] = evenNumSum;
        arr1[1] = oddNumsum;

        System.out.println(Arrays.toString(arr1));
    }
}
