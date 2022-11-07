package com.xiaoer.homework.array_exercise;

public class ArrayDemo6_06
{
    public static void main(String[] args) {
        int[] nums = new int[]{11, 22, 33, 44, 22, 55};
        String str = "[";//str表示结果字符串,先拼一个[符号
        for (int index = 0; index < nums.length; index++) {
            // 把每一个元素拼接在str后面
            str = str + nums[index];
            // 如果是最后一个元素,则不拼接,而是]
            if (index == nums.length - 1) {
                str = str + "]";
            } else {
                // 如果不是最后一个元素拼接,
                str = str + ", ";
            }
        }
        System.out.println(str);
    }
}
