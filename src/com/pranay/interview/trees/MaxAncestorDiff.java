package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class MaxAncestorDiff {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        MaxAncestorDiff mad = new MaxAncestorDiff();
        int ans = mad.maxAncestorDiff(root);
        System.out.println("Ans : " + ans);
    }

    private int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int min, int max) {
        if (root == null)
            return max - min;

        max = Math.max(root.val, max);
        min = Math.min(root.val, min);

        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }
}
