package com.cjh.leetcode;

import java.util.Arrays;

public class LC518 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change2D(5, new int[]{1, 2, 5}));
    }


static class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if(j-coins[i]>=0) dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
    public int change2D(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        for (int[] ints : dp) {
            ints[0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1]>=0) dp[i][j] += dp[i][j - coins[i-1]];
            }
        }
        return dp[n][amount];
    }
}
}
