package com.cjh.ds.sgm;

public class ZkwSegmentTree {
    int n;
    int[] st;

    public ZkwSegmentTree(int[] nums) {
        n = nums.length;
        st = new int[2 * n];
        for (int i = n; i < 2 * n; i++) st[i] = nums[i - n];
        for (int i = n - 1; i > 0; i--) st[i] = st[2 * i] + st[2 * i + 1];
    }

    public void update(int i, int val) {
        int diff = val - st[i + n];
        for (i += n; i > 0; i /= 2) st[i] += diff;
    }

    public int sumRange(int i, int j) {
        int res = 0;
        for (i += n, j += n; i <= j; i /= 2, j /= 2) {
            // 如果是右子节点，加上右子节点的值，让i右移到下一个节点
            if (i % 2 == 1) res += st[i++];
            // 同理
            if (j % 2 == 0) res += st[j--];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((char)('a' + 1));
    }
}
