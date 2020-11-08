package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

/**
 * 538/1038. Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */

public class GreaterSumTree {
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

        GreaterSumTree gst = new GreaterSumTree();
        TreeNode newRoot = gst.convertBST(root);
        System.out.println(newRoot);
    }

    private TreeNode convertBST(TreeNode root) {
        gst(root, 0);
        return root;
    }

    private int gst(TreeNode root, int val) {
        if (root == null)
            return val;

        val = gst(root.right, val);
        val += root.val;
        root.val = val;
        val = gst(root.left, val);

        return val;
    }
}
