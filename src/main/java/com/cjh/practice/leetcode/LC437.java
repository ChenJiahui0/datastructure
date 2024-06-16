package com.cjh.practice.leetcode;

import com.cjh.practice.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC437 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000}), 0));
        System.out.println(solution.pathSum2(TreeNode.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
    }

    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            return rootSum(root, targetSum) +
                    pathSum(root.left, targetSum) +
                    pathSum(root.right, targetSum);
        }

        public int rootSum(TreeNode root, long targetSum) {
            if (root == null) return 0;
            int ans = 0;
            if (root.val == targetSum) {
                ans += 1;
            }
            return ans
                    + rootSum(root.left, targetSum - root.val)
                    + rootSum(root.right, targetSum - root.val);
        }

        public int pathSum2(TreeNode root, int targetSum) {
            Map<Long, Integer> m = new HashMap<>();
            m.put(0L, 1);
            return prefixSum(root, targetSum, m, 0L);
        }

        public int prefixSum(TreeNode root, int targetSum, Map<Long, Integer> m, long prefixSum) {
            if (root == null) return 0;
            long tmp = prefixSum + root.val;
            int ans = 0;
            ans += m.getOrDefault(tmp - targetSum, 0);
            m.put(tmp, m.getOrDefault(tmp, 0) + 1);
            ans += prefixSum(root.left, targetSum, m, tmp);
            ans += prefixSum(root.right, targetSum, m, tmp);
            m.put(tmp, m.getOrDefault(tmp, 0) - 1);
            return ans;
        }
    }
}
