package com.pranay.interview.trees;

public class InvertBinaryTree {
    static Node root;
    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();
//        root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(7);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
//        root.right.left = new Node(6);
//        root.right.right = new Node(9);

        root = new Node(4);
        root.left = new Node(5);
        root.left.left = new Node(6);

        printPreorder(root);
        Node rootNode = invertTree(root);
        System.out.println("after : ");
        printPreorder(rootNode);
    }

    private static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        printPreorder(node.left);
        System.out.print(node.data);
        printPreorder(node.right);
    }

    private static Node invertTree(Node root) {
        invert(root);
        return root;
    }

    private static void invert(Node node) {
        if (node == null) {
            return;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        invert(node.left);
        invert(node.right);
    }
}
