package com.pranay.interview.treeAll;

import com.pranay.interview.common.TreeNode;

public class TrimBST {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        int lo = 1;
        int hi = 3;
        TreeNode newRoot = trimBST(root, lo, hi);

        System.out.println("New BST : " + newRoot);
    }

    private static TreeNode trimBST(TreeNode node, int lo, int hi) {
        if (node == null)
            return node;

        if (node.val > hi)
            return trimBST(node.left, lo, hi);

        if (node.val < lo)
            return trimBST(node.right, lo, hi);

        node.left = trimBST(node.left, lo, hi);
        node.right = trimBST(node.right, lo, hi);
        return node;
    }

// class Solution:
//     def trimBST(self, root, L, R):
//         if root is None:
//             return None
//
//         left = self.trimBST(root.left, L, R)
//         right = self.trimBST(root.right, L, R)
//
//         if L <= root.val <= R:
//             root.left, root.right = left, right
//             return root
//
//         return left if left is not None else right
}
