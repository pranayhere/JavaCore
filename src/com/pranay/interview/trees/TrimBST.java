package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class TrimBST {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(5);

        TreeNode ans  = trimBST(root, 0, 5);
        System.out.println(ans);
    }

    private static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        if (root.val >= high)
            return trimBST(root.left, low, high);

        if (root.val <= low)
            return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
