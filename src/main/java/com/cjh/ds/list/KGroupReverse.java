package com.cjh.ds.list;

public class KGroupReverse {
    public static void main(String[] args) {
        int count = 0;
        while (count++ < 2) {
        }
        System.out.println(count);
//        ListNode listNode = new ListNode(0);
//        ListNode cur = listNode;
//        for (int i = 1; i < 6; i++) {
//            cur.next = new ListNode(i);
//            cur = cur.next;
//        }
//        Solution solution = new Solution();
//        solution.reverseKGroup(listNode.next, 2);
    }
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null) return head;
            ListNode a,b;
            a = b = head;
            for(int i=0;i<k;i++){
                if(b==null) return head;
                b = b.next;
            }
            ListNode newHead = reverse(a,b);
            a.next = reverseKGroup(b,k);
            return newHead;
        }
        ListNode reverse(ListNode head,ListNode tair){
            ListNode prev = new ListNode(-1);
            prev.next = head;
            while(head != tair){
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
            }
            return prev;
        }
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
