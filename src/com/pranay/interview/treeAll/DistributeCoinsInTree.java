package com.pranay.interview.treeAll;

import com.pranay.interview.common.TreeNode;

/**
 * 979. Distribute Coins in Binary Tree
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */
public class DistributeCoinsInTree {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        DistributeCoinsInTree dct = new DistributeCoinsInTree();
        int moves = dct.distributeCoins(root);
        System.out.println("Number of moves : " + moves);
    }

    int ans;
    private int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int L = dfs(node.left);
        int R = dfs(node.right);

        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
