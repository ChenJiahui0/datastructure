package com.cjh.leetcode;

import java.util.*;

public class LC140 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }

    static class Solution {
        List<String> res = new ArrayList<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            List<Integer>[] dp = new ArrayList[s.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new ArrayList<>();
            }
            dp[0].add(0);
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (!dp[j].isEmpty() && set.contains(s.substring(j, i))) {
                        dp[i].add(j);
                    }
                }
            }
            getResult(dp, s.length(), "", s);
            return res;
        }

        public void getResult(List<Integer>[] dp, int index, String cur, String s) {
            if (index == 0) {
                res.add(cur.trim());
                return;
            }
            for (Integer i : dp[index]) {
                getResult(dp, i, s.substring(i, index) + " " + cur, s);
            }
        }
    }

}
