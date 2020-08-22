package com.pranay.interview.BookSols;

public class BTCheckSymmetry {
    static Node root;
    public static void main(String[] args) {
        root = new Node(314);
        root.left = new Node(6);
        root.right = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(2);
        root.left.right.right = new Node(3);
        root.right.left.left = new Node(3);

        boolean ans = isSymmetric(root);
        System.out.println("Ans : " + ans);
    }

    private static boolean isSymmetric(Node node) {
        return node == null || checkSymmetric(node.left, node.right);
    }

    private static boolean checkSymmetric(Node left, Node right) {
        if (left == null && right == null)
            return true;

        if (left != null && right != null)
            return left.val == right.val
                && checkSymmetric(left.left, right.right)
                && checkSymmetric(left.right, right.left);

        return false;
    }
}
