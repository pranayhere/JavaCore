package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestInBST {
    static Node root;
    public static void main(String[] args) {
        KthSmallestInBST tree = new KthSmallestInBST();
        root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.right = new Node(2);

        int k = 2;
        int val = kthSmallest(root, k);
        System.out.println("kth smallest : " + val);
    }

    private static int kthSmallest(Node node, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(node, list);
        System.out.println(list);
        return list.get(k - 1);
    }

    private static void inorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    private static int kthSmallest2(Node node, int k) {
        LinkedList<Node> stack = new LinkedList<Node>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.data;
            root = root.right;
        }
    }
}