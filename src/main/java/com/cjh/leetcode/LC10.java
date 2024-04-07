package com.cjh.leetcode;

public class LC10 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatchDp("aab", "c*a*b"));
    }


    static class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) return s.isEmpty();
            boolean isFirstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
            if (p.length() >= 2 && p.charAt(1) == '*') {
                // *用作0个字符
                boolean match = isMatch(s, p.substring(2));
                // s指针后移1位
                return match || (isFirstMatch && isMatch(s.substring(1), p));
            } else {
                return isFirstMatch && isMatch(s.substring(1), p.substring(1));
            }
        }

        public boolean isMatchDp(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int j = 2; j < n; j += 2)
                dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        if ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }

}
