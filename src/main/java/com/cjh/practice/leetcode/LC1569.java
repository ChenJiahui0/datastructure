package com.cjh.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1569 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numOfWays(new int[]{3, 4, 5, 1, 2}));
    }


    static class Solution {
        int mod = (int) 1e9 + 7;
        Integer[][] memo;

        public int numOfWays(int[] nums) {
            int n = nums.length;
            memo = new Integer[n][n];
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            long res = (mod + totalWays(list) - 1) % mod;
            return (int) res;
        }

        public long totalWays(List<Integer> list) {
            if (list.size() == 0) return 1;
            int head = list.get(0);
            List<Integer> r = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            for (Integer i : list) {
                if (i > head) r.add(i);
                else if (i < head) l.add(i);
            }
            return totalWays(r) * totalWays(l) * nCk(list.size() - 1, l.size());
        }

        public int nCk(int n, int k) {
            if (n == k || k == 0) return 1;
            if (memo[n][k] != null) return memo[n][k];
            return memo[n][k] = (nCk(n - 1, k) + nCk(n - 1, k - 1)) % mod;
        }
    }


}
