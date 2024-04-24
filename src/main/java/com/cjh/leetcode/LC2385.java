package com.cjh.leetcode;

public class LC2385 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.amountOfTime(TreeNode.buildTree(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2}), 3));
        System.out.println(solution.amountOfTime(TreeNode.buildTree(new Integer[]{1, 2, null, 3, null, 4, null, 5}), 4));
    }

    static class Solution {
        int ans = 0;

        public int amountOfTime(TreeNode root, int start) {
            dfs(root, start);
            return ans;
        }

        public int dfs(TreeNode root, int start) {
            if (root == null) return 0;
            int l = dfs(root.left, start);
            int r = dfs(root.right, start);
            if (root.val == start) {
                ans = Math.max(l, r);
                // 负数表示找到目标节点，值为离目标节点的距离
                return -1;
            } else {
                // 左子树或右子树含有目标节点，那么此时尝试更新答案，答案为无目标节点子树长度+到目标节点距离
                if (l < 0 || r < 0) {
                    ans = Math.max(Math.abs(l) + Math.abs(r), ans);
                    // 返回目标节点到父节点的距离，值为目标节点到当前节点距离+1
                    return Math.min(l, r)- 1;
                } else {
                    // 目标节点不在子树上，选择最长的子树长度
                    return Math.max(l, r) + 1;
                }
            }
        }
    }

}
