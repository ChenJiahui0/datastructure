package com.cjh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC894 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.allPossibleFBT(3));
        solution.allPossibleFBTDp(7).forEach(n-> System.out.println(TreeNode.preOrder(n)));
        LinkedList s;
    }

    static class Solution {
        // dfs
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> list = new ArrayList<>();
            if(n%2==0) return list;
            if(n==1) {
                list.add(new TreeNode(0));
                return list;
            }
            for(int i=1;i<n;i+=2){
                List<TreeNode> leftSubtrees = allPossibleFBT(i);
                List<TreeNode> rightSubtrees = allPossibleFBT(n-1-i);
                for(TreeNode leftSubtree:leftSubtrees){
                    for(TreeNode rightSubtree:rightSubtrees){
                        list.add(new TreeNode(0,leftSubtree,rightSubtree));
                    }
                }
            }
            return list;
        }

        // dp
        public List<TreeNode> allPossibleFBTDp(int n) {
            List<TreeNode>[] dp = new List[n+1];
            // dp[i]表示
            for (int i = 0; i < n + 1; i++) {
                dp[i] = new ArrayList<>();
            }
            dp[1].add(new TreeNode(0));
            for (int i = 3; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    List<TreeNode> leftSubtrees = dp[i - j - 1];
                    List<TreeNode> rightSubtrees = dp[j];
                    for (TreeNode leftSubtree : leftSubtrees) {
                        for (TreeNode rightSubtree : rightSubtrees) {
                            dp[i].add(new TreeNode(0, leftSubtree, rightSubtree));
                        }
                    }
                }
            }

            return dp[n];
        }
    }
}
