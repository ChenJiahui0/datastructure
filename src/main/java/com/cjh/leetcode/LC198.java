package com.cjh.leetcode;

import java.util.Arrays;

public class LC198 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2,1,1,2}));
        System.out.println(solution.robIterative(new int[]{2,1,1,2}));
        System.out.println(solution.robIterative1D(new int[]{2,1,1,2}));
    }

    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n+1][2];
            dp[0][0] = dp[0][1] = 0;
            dfs(nums,1,dp);
            return Math.max(dp[n][0],dp[n][1]);
        }
        public void dfs(int[] nums,int index,int[][] dp){
            if(index>nums.length) return;
            dp[index][0] = dp[index - 1][1] + nums[index - 1];
            dp[index][1] = Math.max(dp[index - 1][0],dp[index-1][1]);
            dfs(nums,index+1,dp);
        }
        public int robIterative(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n+1][2];
            dp[0][0] = dp[0][1] = 0;
            dfs(nums,1,dp);
            for (int i = 1; i < n + 1; i++) {
                dp[i][0] = dp[i - 1][1] + nums[i - 1];
                dp[i][1] = Math.max(dp[i - 1][0],dp[i-1][1]);
            }
            return Math.max(dp[n][0],dp[n][1]);
        }

        // 一维DP
        public int robIterative1D(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i < n + 1; i++) {
                dp[i] = Math.max(nums[i-1] + dp[i-2],dp[i-1]);
            }
            return dp[n];
        }
        
    }

}
