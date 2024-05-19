package com.cjh.practice.leetcode;

public class LC2182 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("z");
        }
        System.out.println(solution.repeatLimitedString(sb.toString(),100000));
    }

    static class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] arr = new int[26];
            for(char c:s.toCharArray()){
                arr[c-'a']++;
            }
            int cur = 25,pre=24;
            StringBuilder sb = new StringBuilder();
            while(cur>=0){
                while(arr[cur]>0){
                    int repeat = Math.min(repeatLimit,arr[cur]);
                    arr[cur] -= repeat;
                    while(repeat-->0){
                        sb.append((char)('a'+cur));
                    }
                    if(arr[cur]>0){
                        while(pre>=0 && arr[pre]==0){
                            pre = pre-1;
                        }
                        if(pre <0 || arr[pre]==0) return sb.toString();
                        arr[pre]--;
                        sb.append((char)('a'+pre));
                    }
                }
                cur = pre;
                pre = pre-1;
            }
            return sb.toString();
        }
    }
}
