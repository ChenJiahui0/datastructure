package com.cjh.leetcode;

import java.util.Arrays;

public class LC322 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.coinChange(new int[]{1,2,5}, 11));
    }


    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int m = coins.length;
            int[] dp = new int[amount+1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < m; i++) {
                for (int j = coins[i]; j <=amount; j++) {
                    if (j-coins[i]>=0){
                        dp[j] = Math.min(dp[j - coins[i]] + 1,dp[j]);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
