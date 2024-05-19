package com.cjh.practice.leetcode;

import java.util.Arrays;

public class LC494 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWaysDp(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWaysDp1D(new int[]{1, 1, 1, 1, 1}, 3));
    }


    static class Solution {
        int count = 0;

        // 回溯法
        public int findTargetSumWays(int[] nums, int target) {
            backtrace(nums,target,0);
            return count;
        }
        private void backtrace(int[] nums,int target,int index){
            if(nums.length == index) {
                if(target == 0){
                    count++;
                }
                return;
            }
            backtrace(nums,target-nums[index],index+1);
            backtrace(nums,target+nums[index],index+1);
        }

        /**
         * dfs + memo
         * a - b = target
         * a + b = sum
         * a = (sum + target) / 2
         * dp[i][j] 表示前i个字符相加是否能得到j
         */
        public int findTargetSumWaysDfsMemo(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            if((sum + target) % 2==1) return 0;
            Integer[][] memo = new Integer[nums.length + 1][(sum + target) / 2 + 1];
            return dfs(memo,nums,(sum + target) / 2,0);
        }
        public int dfs(Integer[][] memo,int[] nums,int target,int index){
            if(index == nums.length) {
                if (target == 0) {
                    return memo[index][target] = 1;
                }
                return 0;
            }
            if(target<0) return 0;
            return memo[index][target] = dfs(memo, nums, target - nums[index], index + 1) + dfs(memo, nums, target, index + 1);
        }

        // 2维
        public int findTargetSumWaysDp(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            if((sum + target) % 2==1) return 0;
            int m = nums.length;
            int n = (sum + target) / 2;
            int[][] memo = new int[m+1][n+1];
            memo[0][0] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    memo[i][j] = memo[i-1][j];
                    if(j-nums[j]>=0){
                        memo[i][j] += memo[i-1][j-nums[j]];
                    }
                }
            }
            return memo[m][n];
        }

        // 1维
        public int findTargetSumWaysDp1D(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            if((sum + target) % 2==1) return 0;
            int m = nums.length;
            int n = (sum + target) / 2;
            int[] memo = new int[n+1];
            memo[0] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = n; j >= 0; j--) {
                    if(j-nums[j]>=0){
                        memo[j] += memo[j-nums[j]];
                    }
                }
            }
            return memo[n];
        }
    }

}
