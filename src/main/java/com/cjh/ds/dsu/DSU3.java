package com.cjh.ds.dsu;

import java.util.Arrays;

/**
 * improved with rank
 */
public class DSU3 {
    int[] parent;
    int[] rank;

    public DSU3(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(rank, 1);
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }else if (rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
        }else{
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }
}
