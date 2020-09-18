package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class BalancedBinaryTree {
    static TreeNode root;
    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean ans = bbt.isBalanced(root);
        System.out.println("Is Balanced : " + ans);
    }

    class HeightNode {
        boolean balanced;
        int height;

        public HeightNode(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root).balanced;
    }

    private HeightNode checkBalanced(TreeNode node) {
        if (node == null)
            return new HeightNode(true, -1);

        HeightNode leftHeight = checkBalanced(node.left);
        if (!leftHeight.balanced)
            return leftHeight;

        HeightNode rightHeight = checkBalanced(node.right);
        if (!rightHeight.balanced)
            return rightHeight;

        int height = Math.max(leftHeight.height, rightHeight.height) + 1;
        boolean isBalanced = Math.abs(leftHeight.height - rightHeight.height) <= 1;

        return new HeightNode(isBalanced, height);
    }
}
