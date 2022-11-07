package com.xiaoer.leetcode_test;
import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
