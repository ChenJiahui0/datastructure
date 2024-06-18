package com.cjh.practice.leetcode;


public class LC522 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLUSlength(new String[]{"aaa","aa","aaa"}));
    }

    static class Solution {
        public int findLUSlength(String[] strs) {
            int ans = -1;
            for(int i=0;i<strs.length;i++){
                boolean flag = true;
                if(ans>strs[i].length()){
                    continue;
                }
                for(int j=0;j<strs.length;j++){
                    if(j!=i && isSubSeq(strs[i],strs[j])){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans = strs[i].length();
                }
            }
            return ans;
        }
        public boolean isSubSeq(String s,String t){
            int i = 0;
            for(char c : t.toCharArray()){
                if(c==s.charAt(i) && ++i==s.length()) return true;
            }
            return false;
        }
    }

}
