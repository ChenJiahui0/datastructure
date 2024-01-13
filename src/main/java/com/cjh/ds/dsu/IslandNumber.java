package com.cjh.ds.dsu;

import java.util.ArrayList;
import java.util.List;

public class IslandNumber {
    public static void main(String[] args) {
        IslandNumber islandNumber = new IslandNumber();
        System.out.println(islandNumber.numsIsland(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
    }
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<Integer> numsIsland(int m, int n, int[][] position){
        DSU dsu = new DSU(m * n);
        boolean[][] isIsland = new boolean[m][n];
        int count=0;
        List<Integer> res = new ArrayList<>();
        for (int[] cur : position) {
            if (isIsland[cur[0]][cur[1]]){
                res.add(count);
            }
            isIsland[cur[0]][cur[1]] = true;
            count++;
            for (int[] dir : dirs) {
                int x = cur[0]+dir[0];
                int y = cur[1]+dir[1];
                if(x<0||x>=m||y<0||y>=n||!isIsland[x][y]) continue;
                int component1 = dsu.find(x * m + y);
                int component2 = dsu.find(cur[0] * m + cur[1]);
                if (component1!= component2) {
                    dsu.union(component1,component2);
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    class DSU{
        int[] parent;
        public DSU(int size){
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }
        public void union(int x,int y){
            parent[find(x)] = find(y);
        }
        public int find(int x){
            if(parent[x]!=x) parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}

