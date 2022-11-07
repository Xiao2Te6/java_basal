package com.xiaoer.homework.array_exercise;

public class ReversedDemo_09
{
    public static void main(String[] args) {
        String[] nums = new String[]{"a","b","c","d","e"};
        String str = "[";//str表示结果字符串,先拼一个[符号
        for (int index = nums.length - 1; index >= 0; index--) {
            // 把每一个元素拼接在str后面
            str = str + nums[index];
            // 如果是最后一个元素,则不拼接,而是]
            if (index == 0) {
                str = str + "]";
            } else {
                // 如果不是最后一个元素拼接,
                str = str + ", ";
            }
        }
        System.out.println(str);
    }
}
