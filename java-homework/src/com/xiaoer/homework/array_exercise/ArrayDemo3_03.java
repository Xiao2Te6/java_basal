package com.xiaoer.homework.array_exercise;

public class ArrayDemo3_03
{
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int size = nums.length;
        nums[0] = 8;
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
