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

public class AllNodesAtDistanceK {
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

        TreeNode target = root.left;
        int K = 2;

        AllNodesAtDistanceK adk = new AllNodesAtDistanceK();
        List<Integer> ans = adk.distanceK(root, target, K);
        System.out.println("Ans : " + ans);
    }

    Map<TreeNode, TreeNode> parents = new HashMap<>();

    private List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();

        q.offer(target);

        int d = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (seen.contains(curr))
                    continue;

                seen.add(curr);

                if (d == k)
                    ans.add(curr.val);

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);

                TreeNode p = parents.getOrDefault(curr, null);

                if (p != null)
                    q.offer(p);
            }

            d++;
        }
        return ans;
    }

    public void dfs(TreeNode curr, TreeNode parent) {
        if (curr == null)
            return;

        parents.put(curr, parent);
        dfs(curr.left, curr);
        dfs(curr.right, curr);
    }
}
