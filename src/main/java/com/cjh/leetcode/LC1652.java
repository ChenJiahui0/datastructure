package com.cjh.leetcode;

import java.util.Arrays;

public class LC1652 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decrypt(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(new Solution().decrypt(new int[]{2, 4, 9, 3}, -2)));
    }

    static class Solution {
        public int[] decrypt(int[] code, int k) {
            // 1 2 3 4
            int n = code.length;
            int[] res = new int[n];
            int r = k > 0 ? k + 1 : n;
            k = Math.abs(k);
            int s = 0;
            for(int i=r-k;i<r;i++){
                s += code[i];
            }
            for(int i=0;i<n;i++){
                res[i] = s;
                s += code[r%n]-code[(r-k)%n];
                r++;
            }
            return res;
        }
    }
}
