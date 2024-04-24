package com.cjh.leetcode;

public class LC1052 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("z");
        }
        System.out.println(solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;
            int sum = 0;
            int i = 0, j = 0;
            int angry = 0;
            int maxAngry = 0;
            while (j < n) {
                sum += customers[j] * (grumpy[j] == 0 ? 1 : 0);
                angry += customers[j] * grumpy[j];
                if (j >= i + minutes) {
                    angry -= customers[i] * grumpy[i];
                    i++;
                }
                j++;
                maxAngry = Math.max(angry, maxAngry);
            }
            return sum + maxAngry;
        }
    }
}
