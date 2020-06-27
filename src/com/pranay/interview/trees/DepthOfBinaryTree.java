package com.pranay.interview.trees;

public class DepthOfBinaryTree {
    static Node root;
    public static void main(String[] args) {
        DepthOfBinaryTree depth = new DepthOfBinaryTree();
        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int depthOfTree = depth.findDepth(root);
        System.out.println("Depth Of Tree : " + depthOfTree);
    }

    private int findDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
