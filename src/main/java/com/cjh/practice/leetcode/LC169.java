package com.cjh.practice.leetcode;

public class LC169 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{1,2,2}));
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int times = 0;
            int constant = nums[0];
            for (int i : nums) {
                if (constant == i) {
                    times++;
                }else{
                    if(times<=0){
                        times = 1;
                        constant = i;
                    }else{
                        times--;
                    }
                }
            }
            return constant;
        }
    }
}
