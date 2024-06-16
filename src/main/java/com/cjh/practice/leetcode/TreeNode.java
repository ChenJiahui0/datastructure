package com.cjh.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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
            while (!queue.isEmpty() && node == null) {
                node = queue.poll();
            }
            if (node != null) {
                if (arr[i] == null) node.left = null;
                else node.left = new TreeNode(arr[i]);
                if (i + 1 < arr.length) {
                    if (arr[i + 1] == null) node.right = null;
                    else node.right = new TreeNode(arr[i + 1]);
                }
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
        if (node == null) return List.of("null");
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
