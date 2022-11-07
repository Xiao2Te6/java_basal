package com.xiaoer.leetcode_test;


/**
 * ���������ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ�������ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢һλ���֡�
 * <p>
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/add-two-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Test02 {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(8))));
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(9, new ListNode(1, new ListNode(6)));
        ListNode l2 = new ListNode(0);
        ListNode test = test(l1, l2);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    public static ListNode test(ListNode l1, ListNode l2) {
        ListNode first = new ListNode();
        ListNode node = first;
        int ten = 0;
        while (l1 != null || l2 != null || ten != 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int c = a + b + ten;
            node.next = new ListNode(c % 10);
            node = node.next;
            ten = c / 10;
            if (l1!= null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return first.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
