package com.cjh.leetcode;

public class LC274 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{3,0,6,1,5}));
    }

    // 0,1,0,1,0,1,1
    // 4,4,3,3,2,2,1
    static class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] arr = new int[n+1];
            for (int citation : citations) {
                arr[Math.min(n,citation)]++;
            }
            int s = 0;
            for(int i=n;i>=0;i--){
                s += arr[i];
                if(s>=i) return i;
            }
            return 0;
        }
    }
}
