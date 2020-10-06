package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

/**
 * 250. Count Univalue Subtrees
 * https://leetcode.com/problems/count-univalue-subtrees/
 */
public class CountUnivalueSubtrees {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        CountUnivalueSubtrees cut = new CountUnivalueSubtrees();
        int count = cut.countUnivalSubtrees(root);
        System.out.println("Count : " + count);
    }

    int count = 0;
    private int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        if (left && right &&
                (root.left == null || root.val == root.left.val) &&
                (root.right == null || root.val == root.right.val)) {
            count++;
            return true;
        }

        return false;
    }
}
