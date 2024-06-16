package com.cjh.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeTree {
}

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.buildTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        solution.bstToGst(root);
    }

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return root;
        TreeNode r = bstToGst(root.right);
        if (r != null) root.val += r.val;
        if (root.left != null) root.left.val += root.val;
        bstToGst(root.left);
        return root.left == null ? root : root.left;
    }
}


