package com.pranay.interview.BookSols;

class Node {
    Node left;
    Node right;
    int val;

    public Node (int val) {
        this.val = val;
    }
}

public class BTHeightBalanced {
    static Node root;

    public static void main(String[] args) {
        BTHeightBalanced tree = new BTHeightBalanced();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4); // try commenting from here, output should be true
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        boolean balanced = isBalanced(root);
        boolean balanced2 = isBalanced(root, new Height());

        System.out.println("Binary tree Balanced? " + balanced + " - " +balanced2);
    }

    private static boolean isBalanced(Node node) {
        if (node == null)
            return true;

        int lh = height(node.left);
        int rh = height(node.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        return false;
    }

    private static int height(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    static class Height {
        int height = 0;
    }

    private static boolean isBalanced(Node node, Height height) {
        if (node == null) {
            height.height = 0;
            return true;
        }

        Height lheight = new Height();
        Height rheight = new Height();

        boolean l = isBalanced(node.left, lheight);
        boolean r = isBalanced(node.right, rheight);

        int lh = lheight.height;
        int rh = rheight.height;

        height.height = Math.max(lh, rh) + 1;

        if (Math.abs(lh - rh) >= 2)
            return false;

        return l && r;
    }
}
