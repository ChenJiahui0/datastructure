package com.cjh.practice.leetcode;

import java.util.Arrays;

public class LC2952 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumAddedCoins(new int[]{1, 4, 10}, 19));
    }

    static class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            int m = coins.length;
            boolean[][] dp = new boolean[m+1][target + 1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= target; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - coins[i-1] >= 0) dp[i][j] |= dp[i-1][j - coins[i-1]];
                }
            }
            for (boolean[] booleans : dp) {
                System.out.println(Arrays.toString(booleans));
            }
            return 0;
        }
    }
}