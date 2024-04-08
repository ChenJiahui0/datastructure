package com.cjh.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LC331 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

    static class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] ss = preorder.split(",");
            Stack<String> stack = new Stack<>();
            for(String s:ss){
                stack.push(s);
                while(stack.size()>=3){
                    String s1 = stack.pop();
                    String s2 = stack.pop();
                    String s3 = stack.pop();
                    if(s1.equals("#") && s2.equals("#")){
                        stack.push("#");
                    }else{
                        stack.push(s3);
                        stack.push(s2);
                        stack.push(s1);
                        break;
                    }
                }
            }
            return stack.size()==1 && stack.peek().equals("#");
        }
    }
}
