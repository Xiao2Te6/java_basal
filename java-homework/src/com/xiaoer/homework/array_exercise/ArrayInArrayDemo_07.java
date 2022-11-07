package com.xiaoer.homework.array_exercise;

public class ArrayInArrayDemo_07
{
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{3,4},{5,6}};
        int[][] arr1 = new int[2][2];
        System.out.println(arr1.length);

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int[] a: arr) {
            for (int b : a) {
                System.out.println(b);
            }
        }
    }
}
