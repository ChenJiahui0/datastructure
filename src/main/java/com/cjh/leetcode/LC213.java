package com.cjh.leetcode;

import java.util.Arrays;

public class LC213 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2,3,2}));
    }

    static class Solution {
        public int rob(int[] nums) {
            int[] arr1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
            int[] arr2 = Arrays.copyOfRange(nums, 1, nums.length);
            return Math.max(interative(arr1), interative(arr2));
        }
        public int interative(int[] nums) {
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
