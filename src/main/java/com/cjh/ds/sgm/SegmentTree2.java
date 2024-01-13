package com.cjh.ds.sgm;

public class SegmentTree2 {
    int[] nums;
    Node root;
    public SegmentTree2(int[] nums){
        this.nums = nums;
        this.root = buildTree(0, nums.length - 1);
    }

    private Node buildTree(int start, int end) {
        if (start>end) return null;
        Node node = new Node(start,end);
        if (start == end) node.val = nums[start];
        else{
            int mid = start + (end - start) / 2;
            node.left = buildTree(start, mid);
            node.right = buildTree(mid + 1, end);
            node.val = Math.max(node.left.val, node.right.val);
        }
        return node;
    }
}

class Node {
    Node left, right;
    int start, end, val;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}