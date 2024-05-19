package com.cjh.practice.leetcode;

import java.util.*;

public class LC924 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1, 2}));
    }


    static class Solution {
        // dsu解法
        public int minMalwareSpread(int[][] graph, int[] initial) {
            DSU dsu = new DSU(graph.length);
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    if (graph[i][j] == 1) dsu.union(i, j);
                }
            }
            int res = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            Arrays.sort(initial);
            for (int i = 0; i < initial.length; i++) {
                Set<Integer> set = new HashSet<>();
                int tmp = 0;
                for (int j = 0; j < initial.length; j++) {
                    if (i == j) continue;
                    set.add(dsu.find(initial[j]));
                }
                for (int j = 0; j < graph.length; j++) {
                    if (set.contains(dsu.find(j))) {
                        tmp++;
                    }
                }
                if (tmp < min) {
                    res = initial[i];
                    min = tmp;
                }
            }
            return res;
        }

        class DSU {
            public int[] parent;

            public DSU(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                return parent[x] == x ? parent[x] : find(parent[x]);
            }

            public void union(int x, int y) {
                parent[find(x)] = find(y);
            }
        }
    }

}
