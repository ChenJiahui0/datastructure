package com.cjh.leetcode;

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


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] arr) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        for (int i = 1; i < arr.length; ) {
            TreeNode node = queue.poll();
            if (node != null) {
                if(arr[i] == null) node.left = null;
                else node.left = new TreeNode(arr[i]);
                if(arr[i+1] == null) node.right = null;
                else node.right = new TreeNode(arr[i + 1]);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                queue.offer(null);
                queue.offer(null);
            }
            i += 2;

        }
        return root;
    }
    public static List<Object> preOrder(TreeNode node) {
        if(node == null) return List.of("null");
        List<Object> res = new ArrayList<>();
        res.add(node.val);
        res.addAll(preOrder(node.left));
        res.addAll(preOrder(node.right));
        return res;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}