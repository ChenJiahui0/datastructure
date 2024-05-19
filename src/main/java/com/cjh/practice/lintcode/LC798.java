package com.cjh.practice.lintcode;

public class LC798 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buy(8, new int[]{3, 2}, new int[]{300, 160}, new int[]{1, 6}));
        System.out.println(solution.buy(8, new int[]{2, 4}, new int[]{100, 100}, new int[]{4, 2}));
    }


    static class Solution {
        /**
         * @param n       手里的钱
         * @param price   石头价格
         * @param weights 石头权重
         * @param amount  石头数量
         * @return 最大权重
         */
        public int buy(int n, int[] price, int[] weights, int[] amount) {
            int[] dp = new int[n + 1];
            int m = price.length;
            for (int i = 0; i < m; i++) {
                for (int j = price[i]; j <= n; j++) {
                    // 可以选k个
                    for (int k = 0; k < amount[i]; k++) {
                        // 拿或者不拿
                        if (j - k * price[i] >= 0) dp[j] = Math.max(dp[j], k * weights[i] + dp[j - k * price[i]]);
                    }
                }
            }
            return dp[n];
        }
    }
}
