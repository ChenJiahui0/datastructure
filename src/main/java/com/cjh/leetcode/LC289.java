package com.cjh.leetcode;

import java.util.Arrays;

public class LC289 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution.gameOfLife(ints);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }


    static class Solution {
        // 0 dead 1 alive 2 aliveToDead 3DeadToAlive
        public void gameOfLife(int[][] board) {
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    int aroundLive = getAroundLive(i,j,board);
                    if(aroundLive<2 || aroundLive>3){
                        board[i][j] = board[i][j]==1?2:0;
                    }else if(aroundLive==3){
                        board[i][j] = board[i][j]==0?3:1;
                    }
                }
            }
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==2){
                        board[i][j]=0;
                    }else if(board[i][j]==3){
                        board[i][j]=1;
                    }
                }
            }
        }
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        public int getAroundLive(int row,int col,int[][] board){
            int alive = 0;
            for(int i=0;i<8;i++){
                int x = dx[i]+row;
                int y = dy[i]+col;
                if(x<0||x>=board.length||y<0||y>=board[0].length) continue;
                if(board[x][y]==1 || board[x][y]==2){
                    alive++;
                }
            }
            return alive;
        }
    }

}
