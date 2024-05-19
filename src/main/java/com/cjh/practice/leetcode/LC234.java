package com.cjh.practice.leetcode;


public class LC234 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome(ListNode.buildList(new int[]{1,2,2,1}));
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode mid = findMid(head);
            ListNode tmp = mid.next;
            mid.next = null;
            tmp = reverse(tmp);
            while(tmp!=null){
                if(tmp.val != head.val) return false;
                tmp = tmp.next;
                head = head.next;
            }
            return head == null;
        }
        public ListNode findMid(ListNode node){
            ListNode slow = node,quick = node;
            while(quick!=null && quick.next!=null){
                slow = slow.next;
                quick = quick.next.next;
            }
            return slow;
        }
        public ListNode reverse(ListNode node){
            ListNode pre = null;
            while(node!=null){
                ListNode tmp = node.next;
                node.next = pre;
                pre = node;
                node = tmp;
            }
            return pre;
        }
    }

}
