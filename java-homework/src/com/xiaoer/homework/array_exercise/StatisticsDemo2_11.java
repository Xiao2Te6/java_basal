package com.xiaoer.homework.array_exercise;

public class StatisticsDemo2_11
{
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,0,2,0},{0,3,2}};
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
               if (arr[i][j] == 0){
                   count++;
               }
            }
        }
        System.out.println(count);
    }
}
