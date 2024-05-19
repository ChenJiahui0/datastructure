package com.cjh.practice.leetcode;

public class LC122 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }


    static class Solution {
        // 0持股 1不持股
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = -prices[0];
            for(int i=1;i<prices.length;i++){
                // 持股
                dp[i][0] = Math.max(dp[i-1][1]-prices[i],dp[i-1][0]);
                // 不持股
                dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
            }
            return dp[prices.length-1][1];
        }

        // 贪心，股票涨了就持有，股票要跌就卖掉
        public int maxProfitGreedy(int[] prices){
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                int tmp = prices[i] - prices[i - 1];
                if (tmp > 0) profit += tmp;
            }
            return profit;
        }
    }

}
