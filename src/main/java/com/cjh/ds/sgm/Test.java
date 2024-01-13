package com.cjh.ds.sgm;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3);
    }
}
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        SegmentTree st = new SegmentTree(1,200000);
        int res = 0;
        for(int num:nums){
            int prefixLength = st.rangeMaxQuery(st,num-k,num-1);
            st.update(st,num,prefixLength+1);
            res = Math.max(res,prefixLength+1);
        }
        return res;
    }
}