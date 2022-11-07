package com.xiaoer.leetcode_test;


/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
