package com.cjh.leetcode;

import java.util.*;

public class LC337 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(TreeNode.buildTree(new Integer[]{2, 1, 3, null, 4})));
        System.out.println(solution.robOptimization(TreeNode.buildTree(new Integer[]{2, 1, 3, null, 4})));
    }

    static class Solution {
        Map<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode node) {
            if (node == null) return 0;
            if (memo.get(node) != null) return memo.get(node);
            // 不选的最大值
            int notRobVal = rob(node.left) + rob(node.right);
            // 选的最大值
            int robVal = node.val;
            if (node.left != null) robVal += rob(node.left.left) + rob(node.left.right);
            if (node.right != null) robVal += rob(node.right.left) + rob(node.right.right);
            int max = Math.max(robVal, notRobVal);
            memo.put(node, max);
            return max;
        }

        public int robOptimization(TreeNode node) {
            if (node == null) return 0;
            int[] res = dfs(node);
            return Math.max(res[0], res[1]);
        }

        public int[] dfs(TreeNode node) {
            // arr[0]表示不抢，arr[1]表示抢
           if(node == null) return new int[]{0,0};
           int[] left = dfs(node.left);
           int[] right = dfs(node.right);
            int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            int rob = node.val + left[0] + right[0];
            return new int[]{notRob, rob};
        }
    }

}
