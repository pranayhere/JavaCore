package com.pranay.interview.trees;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 *
 * Output:
 * [[9], [3,15], [20], [7]]
 */

public class VerticalOrderTraversal {
    static Node root;
    public static void main(String[] args) {
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
        List<List<Integer>> traversal = verticalOrder(root);
        System.out.println(traversal);
    }

    private static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        int minColIdx = 0;
        int maxColIdx = 0;

        if (root == null) {
            return null;
        }

        Queue<Pair<Node, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> p = q.poll();
            Node curr = p.getKey();
            Integer columnIdx = p.getValue();

            if (curr == null) {
                continue;
            }

            minColIdx = Math.min(minColIdx, columnIdx);
            maxColIdx = Math.max(maxColIdx, columnIdx);

            columnTable.computeIfAbsent(columnIdx, k -> new LinkedList<>()).add(curr.data);
            q.offer(new Pair<>(curr.left, columnIdx - 1));
            q.offer(new Pair<>(curr.right, columnIdx + 1));
        }

        for (int i = minColIdx; i<= maxColIdx; i++) {
            res.add(columnTable.get(i));
        }
        return res;
    }
}
