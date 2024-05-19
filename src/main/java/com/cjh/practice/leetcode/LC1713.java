package com.cjh.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1713 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4}));
    }

    static class Solution {
        public int minOperations(int[] target, int[] arr) {
            int n = target.length;
            Map<Integer, Integer> pos = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                pos.put(target[i], i);
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = pos.getOrDefault(arr[i], -1);
            }
            int[] d = new int[target.length];
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==-1) continue;
                int left=0,right=res;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (d[mid] < arr[i]) {
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                d[left] = arr[i];
                if(res==left) res++;
            }
            return target.length - res;
        }
    }
}
