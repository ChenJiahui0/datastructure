package com.cjh.practice.leetcode;

import java.util.Arrays;

public class LC1686 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7}));
    }

    static class Solution {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int[] arr = new int[aliceValues.length];
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = aliceValues[i] + bobValues[i];
                sum = sum + aliceValues[i] - bobValues[i];
            }
            Arrays.sort(arr);
            for (int i = arr.length-1; i >= 0; i--) {
                sum += ((i % 2) == 0 ? arr[i] : -arr[i]);
            }
            return Integer.compare(sum, 0);
        }
    }
}
