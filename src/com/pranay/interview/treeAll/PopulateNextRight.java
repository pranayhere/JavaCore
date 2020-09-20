package com.pranay.interview.treeAll;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulateNextRight {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static Node root;
    public static void main(String[] args) {
        PopulateNextRight pnr = new PopulateNextRight();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node node = pnr.connect(root);
        System.out.println("Node : " + node);
    }

    public Node connect(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int size = q.size();

            Node curr = null;
            Node next = null;
            for (int i = 0; i < size; i++) {
                curr = q.poll();

                if (i < size - 1) {
                    next = q.peek();
                    curr.next = next;
                }

                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
        return node;
    }
}
