package com.pranay.interview.graph;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 863. All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesOfDistanceK {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = new TreeNode(5);
        int dist = 2;

        AllNodesOfDistanceK dk = new AllNodesOfDistanceK();
        List<Integer> ans = dk.distanceK(root, target, dist);
        System.out.println("Ans : " + ans);
    }

    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int dist) {
        // map parent child
        dfs(root, null);

        System.out.println(parent);

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();

        q.offer(target);
        seen.add(target);

        int d = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                seen.add(curr);

                if (d == dist)
                    ans.add(curr.val);

                if (curr.left != null && !seen.contains(curr.left))
                    q.offer(curr.left);

                if (curr.right != null && !seen.contains(curr.right))
                    q.offer(curr.right);
                TreeNode p = parent.getOrDefault(curr, null);

                if (p != null && !seen.contains(p))
                    q.offer(p);
            }
            d++;
        }
        return ans;
    }

    private void dfs(TreeNode node, TreeNode par) {
        if (node == null)
            return;

        parent.put(node, par);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
