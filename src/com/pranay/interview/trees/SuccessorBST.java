package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class SuccessorBST {
    static TreeNode root;
    public static void main(String[] args) {
        SuccessorBST tree = new SuccessorBST();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        TreeNode p = new TreeNode(12);
        TreeNode pre = tree.successor(root, p);
        System.out.println("Successor in BST : " + pre.val);
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val)
            return successor(root.right, p);
        else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}
