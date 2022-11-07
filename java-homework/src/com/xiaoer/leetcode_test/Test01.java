package com.xiaoer.leetcode_test;

import java.util.Arrays;

/**
 * 找出数组中两数之和等于给定值的两个数并返回其索引
 */
public class Test01 {
    public static void main(String[] args) {
        int[] ints = new int[]{3,2,4};
        int[] ints1 = twoSum(ints, 6);
        System.out.println(Arrays.toString(ints1));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if ((nums[i] + nums[j]) == target){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return null;
    }
}
