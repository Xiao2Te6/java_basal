package com.xiaoer.leetcode_test;
import java.util.Arrays;

/**
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С��������nums1 ��nums2�������ҳ���������������������� ��λ�� ��
 *
 * �㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(log (m+n))
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Test04 {
    public static void main(String[] args) {
        int[] ints = {1,3};
        int[] ints2 = {2,6};
        System.out.println(findMedianSortedArrays(ints, ints2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sumNums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++){
            sumNums[i] = nums1[i];
        }
        for(int i = 0 ; i < nums2.length; i++){
            sumNums[i + nums1.length] = nums2[i];
        }
        Arrays.sort(sumNums);
        if (sumNums.length %2 == 0){
            int a = sumNums[sumNums.length/2];
            int b = sumNums[sumNums.length/2 - 1];
            return (a+b)/2.0;
        }else{
            return sumNums[sumNums.length/2] * 1.0;
        }
    }
}
