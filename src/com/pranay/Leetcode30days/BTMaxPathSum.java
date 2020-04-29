package com.pranay.Leetcode30days;

public class BTMaxPathSum {
    static Node root;
    static int maxSum;
    public static void main(String[] args) {
        BTMaxPathSum tree = new BTMaxPathSum();
        tree.root = new Node(-10);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);

        int sum = maxPathSum(root);
        System.out.println("Max Path Sum : " + sum);
    }

    private static int maxPathSum(Node node) {
        maxSum = Integer.MIN_VALUE;
        findMaxSum(node);
        return maxSum;
    }

    private static int findMaxSum(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, findMaxSum(node.left));
        int right = Math.max(0, findMaxSum(node.right));
        maxSum = Math.max(maxSum, left + right + node.data);
        return Math.max(left, right) + node.data;
    }
}