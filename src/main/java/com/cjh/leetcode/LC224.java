package com.cjh.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LC224 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.calculate("1 + 1");
    }

    static class Solution {
        public int calculate(String s) {
            Stack<Character> cs = new Stack<>();
            Stack<Integer> is = new Stack<>();
            is.push(0);
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(isNum(c)){
                    if(cs.isEmpty()){
                        is.push(is.pop()*10+(c-'0'));
                    }else{
                        char op = cs.pop();
                        if(op=='(') cs.push(c);
                        else if(op==')') cs.pop();
                        else if(op=='+') is.push(is.pop()+(c-'0'));
                        else if(op=='-') is.push(is.pop()-(c-'0'));
                    }
                }else{
                    if(c=='(') cs.push(c);
                    else if(c==')') cs.pop();
                    else if(c=='+') cs.push(c);
                    else if(c=='-') cs.push(c);
                }
            }
            return is.pop();
        }
        public boolean isNum(char c){
            return c >= '0' && c<='9';
        }
    }
}
