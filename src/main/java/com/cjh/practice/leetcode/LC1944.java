package com.cjh.practice.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC1944 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canSeePersonsCount(new int[]{10,6,5,11,9});
    }

    static class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                    ans[stack.pop()]++;
                }
                if (!stack.isEmpty()) {
                    ans[stack.peek()]++;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
