package com.pranay.interview.trees;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */

import com.pranay.interview.common.TreeNode;

public class BstToGreaterTree {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        TreeNode ans = convertBST(root);
        System.out.println(ans);
    }

    private static TreeNode convertBST(TreeNode root) {
        convert(root, 0);
        return root;
    }

    public static int convert(TreeNode root, int val) {
        if (root == null)
            return val;

        val = convert(root.right, root.val);
        val += root.val;
        root.val = val;
        val = convert(root.left, root.val);

        return val;
    }
}
