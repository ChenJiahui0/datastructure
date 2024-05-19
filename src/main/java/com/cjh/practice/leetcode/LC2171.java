package com.cjh.practice.leetcode;

import java.util.Arrays;

public class LC2171 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumRemoval(new int[]{10,6,5,11,9});
    }

    static class Solution {
        public long minimumRemoval(int[] beans) {
            Arrays.sort(beans);
            long sum = 0;
            for(int bean:beans) sum += bean;
            long n = beans.length;
            long res = Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                res = Math.min(sum- beans[i] *(n-i),res);
            }
            return res;
        }
    }
}
