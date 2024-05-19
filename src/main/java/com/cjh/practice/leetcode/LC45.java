package com.cjh.practice.leetcode;

public class LC45 {
    static class Solution {
        public int jump(int[] nums) {
            if(nums.length==1) return 0;
            int maxIndex=0;
            int end = 0;
            int step = 0;
            for(int i=0;i<nums.length;i++){
                maxIndex = Math.max(maxIndex,i+nums[i]);
                // 走不下去了
                if(i == end){
                    end = maxIndex;
                    step++;
                    if(end >= nums.length-1) break;
                }
            }
            return step;
        }
    }
}
