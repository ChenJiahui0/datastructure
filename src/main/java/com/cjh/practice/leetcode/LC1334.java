package com.cjh.practice.leetcode;

public class LC1334 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2);
    }

    static class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            Integer[][] d = new Integer[n][n];
            for(int i=0;i<n;i++){
                d[i][i] = 0;
            }
            for(int[] edge:edges){
                d[edge[0]][edge[1]] = edge[2];
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(d[j][i] == null) continue;
                    for(int k=0;k<n;k++){
                        if(d[i][k]==null) continue;
                        d[j][k] = Math.min(d[j][k]==null?Integer.MAX_VALUE:d[j][k],d[j][i]+d[i][k]);
                    }
                }
            }
            int res = 0;
            int minCnt = n;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i && d[i][j]!=null && d[i][j] <= distanceThreshold) {
                        cnt++;
                    }
                }
                if (cnt <= minCnt) { // 相等时取最大的 i
                    minCnt = cnt;
                    res = i;
                }
            }
            return res;
        }
    }

}
