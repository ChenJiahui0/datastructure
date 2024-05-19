package com.cjh.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(3));
    }


    static class Solution {
        public List<List<Integer>> generate(int numRows) {

            memo = new Integer[numRows + 1][numRows + 1];
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> tmp = new ArrayList<>();
                for (int k = 0; k <= i; k++) {
                    tmp.add(nCk(numRows, k));
                }
                res.add(tmp);
            }

            return res;
        }

        Integer[][] memo;

        public int nCk(int n, int k) {
            if (k == 0 || n == k) return 1;
            if (memo[n][k] != null) return memo[n][k];
            int res = nCk(n - 1, k - 1) + nCk(n - 1, k);
            return memo[n][k] = res;
        }
    }

}
