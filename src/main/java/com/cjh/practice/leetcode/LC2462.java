package com.cjh.leetcode;

import java.util.PriorityQueue;

public class LC2462 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalCost(new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58}, 11, 2));
    }


    static class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b)-> (a[0]-b[0]==0)?a[1]-b[1]:a[0]-b[0]);
            int l=0,r=costs.length-1;
            while(l<candidates){
                q.offer(new int[]{costs[l],l});
                q.offer(new int[]{costs[r],r});
                l++;
                r--;
            }
            long sum = 0;
            while(k-->0){
                var arr = q.poll();
                sum += arr[0];
                if(arr[1]<=l &&l<=r){
                    q.offer(new int[]{costs[l],l});
                    l++;
                }else if(arr[1]>=r && l<=r){
                    q.offer(new int[]{costs[r],r});
                    r--;
                }
            }
            return sum;
        }
    }

}
