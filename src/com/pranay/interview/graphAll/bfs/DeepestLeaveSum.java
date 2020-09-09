package com.pranay.interview.graphAll.bfs;

import com.pranay.GeeksForGeeks.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeepestLeaveSum {
    static Node root;
    public static void main(String[] args) {
        DeepestLeaveSum dls = new DeepestLeaveSum();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);

        int sum = dls.deepestLeavesSum(root);
        System.out.println("Sum of Deepest nodes : " + sum);
    }

    // sum of levels
    private int deepestLeavesSum(Node node) {
        int sum = 0;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                sum += curr.data;

                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
        return sum;
    }
}
