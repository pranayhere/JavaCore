package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

/**
 * 1644. Lowest Common Ancestor of a Binary Tree II
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/926561/Java-DFS-recursion
 */
public class BtLowestCommonAncestor2 {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        BtLowestCommonAncestor2 btlca = new BtLowestCommonAncestor2();
        TreeNode lca = btlca.findLCA(root, new TreeNode(5), new TreeNode(1));
        System.out.println("LCA : " + lca.val);
    }

    int count = 0;
    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = dfs(root, p, q);
        return count == 2 ? res : null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root.val == p.val || root.val == q.val) {
            count++; // need this for (5,10) and (5,4) case
            return root;
        }

        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);

        if (l != null && r != null)
            return root;

        return (l != null) ? l : r;
    }
}
