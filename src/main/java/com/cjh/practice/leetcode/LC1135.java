package com.cjh.practice.leetcode;

import java.util.*;

public class LC1135 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
    }


    static class Solution {
        /**
         * @param n     城市数量
         * @param edges
         * @return
         */
        public int minimumCost(int n, int[][] edges) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1], cost = edge[2];
                graph.computeIfAbsent(x, (a) -> new ArrayList<>()).add(new int[]{x, y, cost});
                graph.computeIfAbsent(y, (a) -> new ArrayList<>()).add(new int[]{y, x, cost});
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.offer(new int[]{1, 1, 0});
            Set<Integer> visited = new HashSet<>();
            int cost = 0;
            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                if (visited.add(edge[1])) {
                    cost += edge[2];
                    List<int[]> tmp = graph.get(edge[1]);
                    for (int[] t : tmp) {
                        pq.offer(t);
                    }
                }
            }
            return visited.size() == n ? cost : -1;
        }
    }
}
