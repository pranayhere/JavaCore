package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
    static Node root;
    public static void main(String[] args) {
        ZigZagLevelOrderTraversal tree = new ZigZagLevelOrderTraversal();
        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        List<List<Integer>> zzLot = tree.zigzagLevelOrder2(root);
        System.out.println(zzLot);
    }

    private List<List<Integer>> zigzagLevelOrder(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(root);
        q.add(new Node(Integer.MAX_VALUE));

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data != Integer.MAX_VALUE) {
                if (is_order_left)
                    level_list.addLast(curr.data);
                else
                    level_list.addFirst(curr.data);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            } else {
                is_order_left = !is_order_left;
                res.add(new ArrayList<>(level_list));
                level_list.clear();
                if (!q.isEmpty())
                    q.add(new Node(Integer.MAX_VALUE));
            }
        }
        return res;
    }

    private List<List<Integer>> zigzagLevelOrder2(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        List<List<Integer>> res = new ArrayList<>();
        boolean flip = false;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (flip)
                    level.addFirst(curr.data);
                else
                    level.addLast(curr.data);

                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            res.add(new ArrayList<>(level));
            level.clear();
            flip = !flip;
        }
        return res;
    }
}