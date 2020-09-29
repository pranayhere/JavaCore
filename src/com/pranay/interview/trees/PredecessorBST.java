package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class PredecessorBST {
    static TreeNode root;
    public static void main(String[] args) {
        PredecessorBST tree = new PredecessorBST();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);


        TreeNode p = new TreeNode(14);
        TreeNode pre = tree.predecessor(root, p);
        System.out.println("Predecessor in BST : " + pre.val);
    }

    private TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return right != null ? right : root;
        }
    }
}
