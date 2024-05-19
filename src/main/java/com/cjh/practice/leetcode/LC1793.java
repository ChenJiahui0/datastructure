package com.cjh.practice.leetcode;

import java.util.Stack;

public class LC1793 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumScore(new int[]{8407,5626,9236,4362,9678,6568,4170,5691,7865,4067,2094,9451,9667,1400,5093,6191,7286,7368,6461,4309,9751,3672,4165,4940,3726,7003,6263,4250,1950,9536,61,1486,6009,6977,7084,2472,7921,1913,117,3543,5075,1582,7987,6710,1331,3023,6856,1125,1475,4158,3422,7864,9178,7255,4997,2128,5441,5910,6719,1308,4444,9746}, 30));
    }

    static class Solution {
        public int maximumScore(int[] nums, int k) {
            k++;
            int[] newNums = new int[nums.length+2];
            System.arraycopy(nums,0,newNums,1,nums.length);
            Stack<Integer> s = new Stack<>();
            int res = 0;
            for(int i=0;i<newNums.length;i++){
                while(!s.isEmpty() && newNums[i]<newNums[s.peek()]){
                    int height = newNums[s.pop()];
                    int right = i-1;
                    int left = s.peek();
                    if(left<k&&right>=k){
                        res = Math.max(res,(right-left)*height);
                    }
                }
                s.push(i);
            }
            return res;
        }
    }
}
