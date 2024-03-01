package com.cjh.leetcode;

import java.util.Arrays;
import java.util.List;

public class LC2369 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPartition(new int[]{803201,803201,803201,803201,803202,803203}));
    }

    static class Solution {
        public boolean validPartition(int[] nums) {
            if(nums.length<2) return false;
            int[] dp = new int[nums.length+1];
            dp[0] = 1;
            if(nums[1]==nums[0]) dp[2] = 1;
            for(int i=2;i<nums.length;i++){
                if(dp[i-2]==1 && nums[i] == nums[i-1] && nums[i-1]==nums[i-2]) dp[i+1] = 1;
                if(dp[i-1]==1 && nums[i]==nums[i-1]) dp[i+1] = 1;
                if(dp[i-2]==1 && nums[i]==nums[i-1]+1 && nums[i-1]==nums[i-2]+1) dp[i+1] = 1;
            }
            return dp[nums.length]==1;
        }
    }

}
