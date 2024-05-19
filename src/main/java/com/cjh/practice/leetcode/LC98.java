package com.cjh.practice.leetcode;

public class LC98 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(TreeNode.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6})));
    }

    static class Solution {
        Integer pre = Integer.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            if(!isValidBST(root.left)){
                return false;
            }
            if(root.val <= pre) return false;
            pre = root.val;
            return isValidBST(root.right);
        }
    }
}
