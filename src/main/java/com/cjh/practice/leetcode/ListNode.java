package com.cjh.practice.leetcode;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
    public static ListNode buildList(int[] arr){
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head.next;
    }
}