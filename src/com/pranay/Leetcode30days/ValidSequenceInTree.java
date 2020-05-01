package com.pranay.Leetcode30days;

public class ValidSequenceInTree {
    static Node root;

    public static void main(String[] args) {
        ValidSequenceInTree tree = new ValidSequenceInTree();
        tree.root = new Node(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(0);
        tree.root.left.left = new Node(0);
        tree.root.left.right = new Node(1);
        tree.root.left.left.right = new Node(1);
        tree.root.left.right.left = new Node(0);
        tree.root.left.right.right = new Node(0);
        tree.root.right.left = new Node(0);

        int[] arr = {0,1,0,1};
        boolean ans = isValidSequence(root, arr);
        System.out.println("Ans : " + ans);
    }

    private static boolean isValidSequence(Node node, int[] arr) {
        return checkPath(node, arr, 0);
    }

    private static boolean checkPath(Node node, int[] arr, int idx) {
        if (node == null || arr.length == idx)
            return false;

        if (node.left == null && node.right == null && node.data == arr[idx] && idx == arr.length - 1) {
            return true;
        }

        return node.data == arr[idx] && (checkPath(node.left, arr, idx + 1) || checkPath(node.right, arr, idx + 1));
    }
}
