package com.cjh.practice.leetcode;

public class LC2529 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
        System.out.println(solution.maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
    }


    static class Solution {
        public int maximumCount(int[] nums) {
            int neg = lowerBounds(nums, 0);
            int pos = nums.length - lowerBounds(nums, 1);
            return Math.max(neg, pos);
        }
    }

    private static int lowerBounds(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        return right;
    }

}
