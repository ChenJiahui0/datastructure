package com.cjh.leetcode;

import java.util.List;
import java.util.Stack;

public class LC2866 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSumOfHeights(List.of(6,5,3,9,2,7)));
    }

    static class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            long res = 0;
            int size = maxHeights.size();
            long[] pre = new long[size];
            long[] suf = new long[size];
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            long tmp = 0;
            for (int i = 0; i < size; i++) {
                int val = maxHeights.get(i);
                while (stack.size() > 1 && maxHeights.get(stack.peek()) >= val) {
                    int index = stack.pop();
                    tmp -= ((long) maxHeights.get(index) * (index - stack.peek()));
                }
                tmp += (long) val * (i-stack.peek());
                stack.push(i);
                pre[i] = tmp;
            }
            stack.clear();
            stack.push(size);
            tmp = 0;
            for (int i = size - 1; i >= 0; i--) {
                int val = maxHeights.get(i);
                while (stack.size() > 1 && maxHeights.get(stack.peek()) >= val) {
                    int index = stack.pop();
                    tmp -= ((long) maxHeights.get(index) * (stack.peek()-index));
                }
                tmp += (long) val * (stack.peek() - i);
                stack.push(i);
                suf[i] = tmp;
            }
            for (int i = 0; i < size; i++) {
                long val = pre[i] + (i+1>=size?0:suf[i+1]);
                res = Math.max(res, val);
            }
            return res;
        }
    }
}
