package com.cjh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC2397 {
    public static void main(String[] args) {
//        int a = 0;
//        a|= (1<<3);
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(~a));
//        int b = 0;
//        b |= 1<<4;
//        System.out.println(Integer.toBinaryString(b & (~a)));
        Solution1 solution = new Solution1();

        System.out.println(solution.maximumRows(new int[][]{{1, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 1}}, 5));
    }
    private static class Solution {
        int res = 0;
        int[][] matrix;
        List<Integer> select = new ArrayList<>();

        public int maximumRows(int[][] matrix, int numSelect) {
            this.matrix = matrix;
            backtracking(numSelect,0);
            return res;
        }
        public void backtracking(int numSelect,Integer idx){
            if(numSelect == 0){
                int m = matrix.length;
                int n = matrix[0].length;
                int coverRow = 0;
                for(int i=0;i<m;i++){
                    int sum = 0;
                    for(int j=0;j<n;j++){
                        sum += select.contains(j)?0:matrix[i][j];
                    }
                    coverRow += sum==0?1:0;
                }
                res = Math.max(coverRow,res);
            }
            if(idx==matrix[0].length) return;
            backtracking(numSelect,idx+1);
            select.add(idx);
            backtracking(numSelect-1,idx+1);
            select.remove(idx);
        }
    }

    static class Solution1 {
        int[][] matrix;
        int res = 0;
        int select = 0;
        int[] masks;
        public int maximumRows(int[][] matrix, int numSelect) {
            this.matrix = matrix;
            masks = new int[matrix.length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    masks[i] |= (matrix[i][j]<<j);
                }
            }
            backtracking(numSelect,0);
            return res;
        }
        public void backtracking(int numSelect,Integer idx){
            if(numSelect == 0){
                int coverRow = 0;
                for(int mask:masks){
                    coverRow += (mask & (~select))==0?1:0;
                }
                res = Math.max(res,coverRow);
            }
            if(idx==matrix[0].length) return;
            backtracking(numSelect,idx+1);
            select |= (1<<idx);
            backtracking(numSelect-1,idx+1);
            select &= ~(1<<idx);
        }
    }
}
