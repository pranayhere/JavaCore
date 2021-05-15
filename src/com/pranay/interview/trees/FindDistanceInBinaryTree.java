package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindDistanceInBinaryTree {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        FindDistanceInBinaryTree distInBst = new FindDistanceInBinaryTree();
        int dist = distInBst.findDistance(root, 5, 0);
        System.out.println("Dist : " + dist);
    }

    Map<Integer, List<Integer>> g = new HashMap<>();

    public int findDistance(TreeNode root, int p, int q) {
        buildGraph(root);
        int dist = bfs(p, q);
        return dist;
    }

    public void buildGraph(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            g.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            g.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
        }

        if (root.right != null) {
            g.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
            g.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
        }

        buildGraph(root.left);
        buildGraph(root.right);
    }

    public int bfs(int p, int dest) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(p);
        Set<Integer> hs = new HashSet<>();

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if (curr == dest)
                    return dist;

                if (hs.contains(curr))
                    continue;

                hs.add(curr);

                for (int neigh: g.getOrDefault(curr, new ArrayList<>())) {
                    q.offer(neigh);
                }
            }

            dist++;
        }

        return -1;
    }
}
