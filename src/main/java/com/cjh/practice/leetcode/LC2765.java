package com.cjh.practice.leetcode;

public class LC2765 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alternatingSubarray(new int[]{2,3,4,3,4}));
    }

    static public class Solution {
        public int alternatingSubarray(int[] nums) {
            int i = 0;
            int ans = -1;
            while (i < nums.length-1) {
                if (nums[i] == nums[i+1]-1){
                    ans = Math.max(ans, 2);
                    int firstIndex = i;
                    while(i<nums.length && nums[i]==nums[firstIndex+(i-firstIndex)%2]){
                        i++;
                    }
                    ans = Math.max(ans, i - firstIndex);
                    i--;
                }else{
                    i++;
                }
            }
            return ans;
        }
    }

}

