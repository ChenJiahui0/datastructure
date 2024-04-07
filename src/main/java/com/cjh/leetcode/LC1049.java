package com.cjh.leetcode;

import java.util.Arrays;

public class LC1049 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }


    static class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = Arrays.stream(stones).sum();
            int target = sum/2;
            int m = stones.length;
            int[] dp = new int[target+1];
            for(int i=0;i<m;i++){
                for(int j=target;j>=0;j--){
                    if(j-stones[i]>=0){
                        dp[j] = Math.max(stones[i] + dp[j-stones[i]],dp[j]);
                    }
                }
            }
            return sum-2*dp[target];
        }
    }

}
