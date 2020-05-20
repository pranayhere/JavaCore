package com.pranay.GeeksForGeeks;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

public class GoodNodesInBinaryTree {
    static Node root;
    int count;

    GoodNodesInBinaryTree() {
        count = 0;
    }

    public static void main(String[] args) {
        GoodNodesInBinaryTree tree = new GoodNodesInBinaryTree();
//        tree.root = new Node(3);
//        tree.root.left = new Node(1);
//        tree.root.left.left = new Node(3);
//        tree.root.right = new Node(4);
//        tree.root.right.left = new Node(1);
//        tree.root.right.right = new Node(5);

        tree.root = new Node(3);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(2);

//        tree.root = new Node(1);

        int count = tree.goodNodes(root);
        System.out.println("Count : " + count);
    }

    private int goodNodes(Node node) {
        int max = node.data;
        dfs(node, max);
        return count;
    }

    private void dfs(Node node, int max) {
        if (node == null) {
            return;
        }
        if (node.data >= max) {
            count ++;
            max = node.data;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
