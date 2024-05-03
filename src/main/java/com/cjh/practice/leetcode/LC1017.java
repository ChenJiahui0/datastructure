package com.cjh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC1017 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.baseNeg2(3));
    }

    /**
     * 与转化为二进制没什么区别，都是除基取余，倒序排列。
     * 不过负二进制的余数可能有0，1，-1，而表示上不能有负数，所以在余数为-1时，要转化为1，同时商+1即可
     */
    static class Solution {
        public String baseNeg2(int n) {
            StringBuilder ans = new StringBuilder();
            while(n!=0){
                int remain = n%(-2);
                ans.append(Math.abs(remain));
                n=remain<0?(n/-2)+1:n/(-2);
            }
            String tmp = ans.reverse().toString();
            return tmp.length()==0?"0":tmp;
        }
    }
}
