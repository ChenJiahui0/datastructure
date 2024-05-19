package com.cjh.practice.leetcode;

public class LC2642 {
    public static void main(String[] args) {
        Graph graph = new Graph(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        System.out.println(graph.shortestPath(3, 2));
    }

    static class Graph {
        Integer[][] f;

        public Graph(int n, int[][] edges) {
            f = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                f[i][i] = 0;
            }
            for (int[] e : edges) {
                f[e[0]][e[1]] = e[2];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (f[i][j] == null) continue;
                    for (int k = 0; k < n; k++) {
                        if (f[i][j] != null && f[j][k] != null) {
                            f[i][k] = Math.min(f[i][k] == null ? Integer.MAX_VALUE : f[i][k], f[i][j] + f[j][k]);
                        }
                    }
                }
            }
        }

        public void addEdge(int[] e) {
            int x = e[0], y = e[1], w = e[2], n = f.length;
            if (f[x][y] != null && w >= f[x][y]) { // 无需更新
                return;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (f[i][x] != null && f[y][j] != null) {
                        f[i][j] = Math.min(f[i][j] == null ? Integer.MAX_VALUE : f[i][j], f[i][x] + w + f[y][j]);
                    }
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            Integer ans = f[node1][node2];
            return ans == null ? -1 : ans;
        }
    }

}
