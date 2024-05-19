package com.cjh.practice.leetcode;

import java.util.Arrays;

public class LC2617 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumVisitedCells(new int[][]{{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}}));
    }

    static class Solution {
        public int minimumVisitedCells(int[][] grid) {
            Integer[][] memo = new Integer[grid.length][grid[0].length];
            for (Integer[] integers : memo) {
                Arrays.fill(integers,Integer.MAX_VALUE);
            }
            var step = dfs(0,0,memo,grid,1);
            return step==Integer.MAX_VALUE?-1:step;
        }
        public int dfs(int i,int j,Integer[][] memo,int[][] grid,int step){
            if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
            if(memo[i][j]<=step) {
                return memo[i][j] = Math.min(memo[i][j],step);
            }
            if(i==grid.length-1 && j==grid[0].length-1) {
                return memo[i][j] = Math.min(memo[i][j],step);
            }
            int min = Integer.MAX_VALUE;
            for(int k=1;k<=grid[i][j];k++){
                min = Math.min(min,dfs(i+k,j,memo,grid,step+1));
                min = Math.min(min,dfs(i,j+k,memo,grid,step+1));
            }
            return memo[i][j] = min;
        }
    }
}
