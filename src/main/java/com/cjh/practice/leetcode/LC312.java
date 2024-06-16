package com.cjh.practice.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LC312 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxCoins(new int[]{3,1,5,8});
    }

    static class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] arr = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                arr[i] = nums[i - 1];
            }
            arr[0] = arr[n + 1] = 1;
            int[][] dp = new int[n + 2][n + 2];
            // 因为j>i所以需要从后往前计算
            for (int i = n; i >= 0; i--) {
                for (int j = i + 2; j < n + 2; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                        for (int[] ints : dp) {
                            System.out.println(Arrays.toString(ints));
                        }
                        System.out.println("\n");
                    }
                }
            }
            return dp[0][n + 1];
        }
    }
}
