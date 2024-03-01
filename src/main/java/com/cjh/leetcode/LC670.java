package com.cjh.leetcode;

import java.util.Arrays;
import java.util.List;

public class LC670 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSwap(98368));
    }

    static class Solution {
        public int maximumSwap(int num) {
            char[] arr = Integer.toString(num).toCharArray();
            int maxIndex = -1, replaceSource = -1, replaceTarget = -1;
            for(int i=arr.length-1;i>=0;i--){
                if(maxIndex == -1 || arr[maxIndex]<arr[i]){
                    maxIndex = i;
                }else if (arr[i]<arr[maxIndex]){
                    replaceSource = maxIndex;
                    replaceTarget = i;
                }
            }
            if(replaceSource == -1) return num;
            char tmp = arr[replaceSource];
            arr[replaceSource] = arr[replaceTarget];
            arr[replaceTarget] = tmp;
            return Integer.parseInt(new String(arr));
        }
    }
}
