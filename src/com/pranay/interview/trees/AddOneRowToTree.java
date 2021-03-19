package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class AddOneRowToTree {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        int v = 1;
        int d = 2;

        AddOneRowToTree aor = new AddOneRowToTree();
        TreeNode ans = aor.addOneRow(root, v, d);
        System.out.println("Ans : " + ans);

        TreeNode ansDfs = aor.addOneRowDfs(root, v, d);
        System.out.println("Ans : " + ansDfs);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (level + 1 == d) {
                    TreeNode dummy = new TreeNode(v);
                    if (curr.left != null) {
                        dummy.left = curr.left;
                        curr.left = dummy;
                    }

                    TreeNode dummy2 = new TreeNode(v);
                    if (curr.right != null) {
                        dummy2.right = curr.right;
                        curr.right = dummy2;
                    }

                    continue;
                }

                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);
            }
            level++;
        }
        return root;
    }

    public TreeNode addOneRowDfs(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            root.left = n;
            return root;
        }

        dfs(root, 1, v, d);
        return root;
    }

    public void dfs(TreeNode curr, int currDepth, int v, int d) {
        if (curr == null)
            return;

        if (currDepth + 1 == d) {
            TreeNode t = curr.left;
            curr.left = new TreeNode(v);
            curr.left.left = t;

            t = curr.right;
            curr.right = new TreeNode(v);
            curr.right.right = t;
        } else {
            dfs(curr.left, currDepth + 1, v, d);
            dfs(curr.right, currDepth + 1, v, d);
        }
    }
}