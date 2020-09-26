package com.pranay.interview.graphAll.bfs;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class SumOfNodesWithEvenValuedGrandparents {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        int sum = sumEvenGrandparent(root);
        System.out.println("Sum : " + sum);
    }

    private static int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val % 2 == 0) {
                    if (curr.right != null) {
                        if (curr.right.right != null)
                            sum += curr.right.right.val;
                        if (curr.right.left != null)
                            sum += curr.right.left.val;
                    }

                    if (curr.left != null) {
                        if (curr.left.left != null)
                            sum += curr.left.left.val;
                        if (curr.left.right != null)
                            sum += curr.left.right.val;
                    }
                }

                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
        return sum;
    }

    // One liner
    public static int sumEvenGrandparentShort(TreeNode root) {
        return helper(root, 1, 1);
    }

    public static int helper(TreeNode node, int p, int gp) {
        if (node == null)
            return 0;

        return helper(node.left, node.val, p) + helper(node.right, node.val, p) + (gp % 2 == 0 ? node.val : 0);
    }
}
