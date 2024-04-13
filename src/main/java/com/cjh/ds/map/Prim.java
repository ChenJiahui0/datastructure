package com.cjh.ds.map;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.*;

public class Prim {
    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference reference = new PhantomReference(obj, queue);
//强引用对象滞空，保留软引用
        obj = null;
        System.gc();
        while (true) {
            Reference poll = queue.poll();
            if (poll != null) {
                System.out.println("gc");
                break;
            }else{
                System.out.println(reference==null);
                System.out.println("no gc");
            }
        }
    }
    /**
     *
     * @param n the number of node
     * @param edges [[node1,node2,cost],...]
     * @return minimun cost
     */
    public static int minimumCost(int n,int[][] edges){
        // 领接表
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], cost = edge[2];
            graph.computeIfAbsent(x, a -> new ArrayList<>()).add(new int[]{x, y, cost});
            graph.computeIfAbsent(y, a -> new ArrayList<>()).add(new int[]{y, x, cost});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{1, 1, 0});
        int costSum = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int x = poll[0], y = poll[1], cost = poll[2];
            if(visited.add(y)){
                costSum += cost;
                for (int[] ints : graph.get(y)) {
                    pq.offer(ints);
                }
            }
        }
        return visited.size() == n ? costSum : -1;
    }
}
