package com.cjh.practice.leetcode;

public class LC5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("rdcvgffdcvf"));
        System.out.println(solution.longestPalindrome("babad"));
    }


    static class Solution {
        public String longestPalindrome(String s) {
            int max = 0;
            int resLeft = 0;
            int resRight = 0;
            for (int i = 0; i < s.length(); i++) {
                int left = i, right = i;
                int len = 0;
                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    len ++;
                    left--;
                }
                while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                    len ++;
                    right++;
                }
                while (left >= 0 && right < s.length()
                        && s.charAt(left) == s.charAt(right)) {
                    len ++;
                    left--;
                    right++;
                }
                if (len > max) {
                    max = len;
                    resLeft = left;
                    resRight = right;
                }
            }
            return s.substring(resLeft+1, resRight + 1);
        }
    }

}
