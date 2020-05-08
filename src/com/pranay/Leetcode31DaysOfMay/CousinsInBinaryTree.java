package com.pranay.Leetcode31DaysOfMay;

import com.pranay.GeeksForGeeks.Node;
import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    static Node root;
    public static void main(String[] args) {
        CousinsInBinaryTree tree = new CousinsInBinaryTree();
        root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(5);

        boolean ans = isCousin(root, 4, 5);
        System.out.println(ans);
    }

    private static boolean isCousin(Node root, int x, int y) {
        // Queue for BFS
        Queue <Node> queue = new LinkedList <> ();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = queue.size();

            for (int i = 0; i < nodesAtDepth; i++) {
                // FIFO
                Node node = queue.remove();

                // Encountered the marker.
                // Siblings should be set to false as we are crossing the boundary.
                if (node == null) {
                    siblings = false;
                } else {
                    if (node.data == x || node.data == y) {
                        // Set both the siblings and cousins flag to true
                        // for a potential first sibling/cousin found.
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            // If the siblings flag is still true this means we are still
                            // within the siblings boundary and hence the nodes are not cousins.
                            return !siblings;
                        }
                    }

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    // Adding the null marker for the siblings
                    queue.add(null);
                }
            }
            // After the end of a level if `cousins` is set to true
            // This means we found only one node at this level
            if (cousins) return false;
        }
        return false;
    }
}
