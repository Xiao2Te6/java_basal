package com.xiaoer.homework.array_exercise;

public class ArrayDemo4_04
{
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int key = 1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (i == key) {
                System.out.println("找到了，这个值的位置在：" + i);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("很遗憾没找到");
        }
    }
}
