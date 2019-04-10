package com.github.cjzhusu.dashleetcode.algorithm;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode extra = new ListNode(0);
        ListNode head = extra;
        int residue = 0;
        while (null != l1 || null != l2) {
            int x = null != l1 ? l1.val : 0;
            int y = null != l2 ? l2.val : 0;
            int sum = residue + x + y;
            residue = sum / 10;
            extra.next = new ListNode(sum % 10);
            extra = extra.next;
            if (null != l1) {
                l1 = l1.next;
            }

            if (null != l2) {
                l2 = l2.next;
            }
        }

        if (residue > 0) {
            extra.next = new ListNode(residue);
        }

        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(res.val);
        while (null != res.next) {
            System.out.println(res.next.val);
            res = res.next;
        }
    }
}
