package com.cjh.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC119 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }


    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            memo = new Integer[rowIndex + 1][rowIndex + 1];
            List<Integer> res = new ArrayList<>();
            for (int k = 0; k <= rowIndex; k++) {
                res.add(nCk(rowIndex, k));
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
