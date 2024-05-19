package com.cjh.practice.leetcode;

import java.util.Arrays;

public class LC238 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.productExceptSelf(new int[]{});
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int zeroNum = 0;
            int product = 1;
            int zeroIndex = -1;
            for (int i=0;i<nums.length;i++) {
                if(nums[i] == 0) {
                    zeroNum++;
                    zeroIndex = i;
                }
                else product *= nums[i];
            }
            if(zeroNum>1) Arrays.fill(nums, 0);
            else if(zeroNum==1){
                Arrays.fill(nums, 0);
                nums[zeroIndex] = product;
            }else{
                for (int i=0;i<nums.length;i++) {
                    nums[i] = product/nums[i];
                }
            }
            return nums;
        }
    }

}
