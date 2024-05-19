package com.cjh.practice.leetcode;

public class LC938 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeSumBST(TreeNode.buildTree(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15));
    }

    static class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if(root == null) return 0;
            if(root.val<low){
                return rangeSumBST(root.right,low,high);
            }
            if(root.val>high){
                return rangeSumBST(root.left,low,high);
            }
            return root.val+rangeSumBST(root.right,low,high)+rangeSumBST(root.left,low,high);
        }
    }
}
