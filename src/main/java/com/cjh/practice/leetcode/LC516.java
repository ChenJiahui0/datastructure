package com.cjh.practice.leetcode;

public class LC516 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }


    static class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i - 1][j + 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                    }
                }
            }
            return dp[n-1][0];
        }
    }


}
