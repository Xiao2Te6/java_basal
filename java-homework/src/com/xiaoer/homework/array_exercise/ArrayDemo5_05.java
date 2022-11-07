package com.xiaoer.homework.array_exercise;

public class ArrayDemo5_05
{
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int max = nums[0];
        for (int a: nums) {
            if (a > max){
                max = a;
            }
        }
        System.out.println("max = " + max);
    }
}
