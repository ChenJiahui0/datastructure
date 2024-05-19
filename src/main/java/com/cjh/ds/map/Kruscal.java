package com.cjh.ds.map;

import java.util.*;

public class Kruscal {
    public static void main(String[] args) {
        System.out.println(minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
    }

    /**
     * @param n     the number of node
     * @param edges [[node1,node2,cost],...]
     * @return minimun cost
     */
    public static int minimumCost(int n, int[][] edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] edge : edges) {
            pq.offer(edge);
        }
        int costSum = 0;
        DSU dsu = new DSU(n + 1);
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int x = poll[0], y = poll[1], cost = poll[2];
            if (dsu.find(x) != dsu.find(y)) {
                dsu.union(x, y);
                costSum += cost;
                n--;
            }
        }
        return n == 1 ? costSum : -1;
    }

    static class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        public int find(int x) {
            if (parent[x] == x) return parent[x];
            return parent[x] = find(parent[x]);
        }
    }
}
