package com.cjh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    }


    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            Map<String,Integer> map = new HashMap<>();
            List<Integer> res = new ArrayList<>();
            for(String word:words){
                map.put(word,map.getOrDefault(word,0)+1);
            }
            int wordLen = words[0].length();
            int i=0;
            while(i<wordLen){
                int left = i,right = i,count = 0;
                i++;
                Map<String,Integer> tmp = new HashMap<>();
                while(right+wordLen<=s.length()){
                    String w = s.substring(right,right+wordLen);
                    right+=wordLen;
                    if(!map.containsKey(w)){
                        count = 0;
                        left = right;
                        tmp.clear();
                    }else{
                        tmp.put(w,tmp.getOrDefault(w,0)+1);
                        count++;
                        while(tmp.getOrDefault(w,0)>map.getOrDefault(w,0)){
                            String tmpWord = s.substring(left,left+wordLen);
                            count--;
                            tmp.put(tmpWord,tmp.getOrDefault(tmpWord,0)-1);
                            left+=wordLen;
                        }
                        if(count==words.length) res.add(left);
                    }
                }
            }
            return res;
        }
    }

}
