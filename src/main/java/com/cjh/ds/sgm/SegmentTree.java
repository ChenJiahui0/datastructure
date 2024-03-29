package com.cjh.ds.sgm;

public class SegmentTree {
    SegmentTree left, right;
    int start, end, val;

    public SegmentTree(int start, int end) {
        this.start = start;
        this.end = end;
        setup(this, start, end);
    }

    private void setup(SegmentTree node, int start, int end) {
        if (start == end) return;
        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new SegmentTree(start, mid);
            node.right = new SegmentTree(mid + 1, end);
        }
        setup(node.left, start, mid);
        setup(node.right, mid + 1, end);
        node.val = Math.max(node.left.val, node.right.val);
    }

    public int rangeMaxQuery(SegmentTree node, int start, int end) {
        if (node.start > end || node.end < start) return 0;
        if (node.start >= start && node.end <= end) return node.val;
        return Math.max(rangeMaxQuery(node.left, start, end), rangeMaxQuery(node.right, start, end));
    }

    public void update(SegmentTree node, int index, int val) {
        if (index < node.start || index > node.end) return;
        if (node.start == node.end) {
            node.val = val;
            return;
        }
        update(node.left, index, val);
        update(node.right, index, val);
        node.val = Math.max(node.left.val, node.right.val);
    }
}
