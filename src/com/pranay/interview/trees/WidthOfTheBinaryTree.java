package com.pranay.interview.trees;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class WidthOfTheBinaryTree {
    static Node root;
    public static void main(String[] args) {
        WidthOfTheBinaryTree wot = new WidthOfTheBinaryTree();
        root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.right = new Node(3);

        int width = wot.widthOfBinaryTree(root);
        System.out.println("Width : " + width);
    }

    private int widthOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair<Node, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> head = q.peek();
            int size = q.size();
            int currIdx = 0;

            for (int i = 0; i< size; i++) {
                Pair<Node, Integer> currPair = q.poll();
                Node curr = currPair.getKey();
                currIdx = currPair.getValue();

                if (curr.left != null)
                    q.offer(new Pair<>(curr.left, 2 * currIdx));
                if (curr.right != null)
                    q.offer(new Pair<>(curr.right, 2 * currIdx + 1));
            }

            maxWidth = Math.max(maxWidth, (2 * currIdx) - head.getValue());
        }
        return maxWidth;
    }
}
