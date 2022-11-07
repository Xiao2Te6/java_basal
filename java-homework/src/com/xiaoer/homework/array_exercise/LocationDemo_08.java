package com.xiaoer.homework.array_exercise;

public class LocationDemo_08
{
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int evenNumSum = 0, oddNumsum = 0;
        for (int i = 0; i < arr.length; i++){
            if (i % 2 == 0){
                evenNumSum += arr[i];
            }else {
                oddNumsum += arr[i];
            }
        }
        System.out.println("evenNumSum = " + evenNumSum);
        System.out.println("oddNumsum = " + oddNumsum);
    }
}
