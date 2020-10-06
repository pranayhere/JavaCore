package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    static TreeNode root;

    public static void main(String[] args) {
//        root = new TreeNode(1);
//        root.left = new TreeNode(10);
//        root.right = new TreeNode(4);
//        root.left.left = new TreeNode(3);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(9);
//        root.left.left.left = new TreeNode(12);
//        root.left.left.right = new TreeNode(8);
//        root.right.left.left = new TreeNode(6);
//        root.right.right.right = new TreeNode(2);

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);

        boolean ans = isEvenOddTree(root);
        System.out.println("Ans : " + ans);
    }

    private static boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean even = true;

        while (q.size() > 0) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while (size-- > 0) {
                root = q.poll();
                level.add(root.val);

                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }

            if (even) {
                int num = 0;
                for (int i = 0; i < level.size(); i++) {
                    if (level.get(i) <= num || level.get(i) % 2 == 0)
                        return false;

                    num = level.get(i);
                }
            } else {
                int num = 0;
                for (int i = level.size() - 1; i >= 0; i--) {
                    if (level.get(i) <= num || level.get(i) % 2 == 1)
                        return false;

                    num = level.get(i);
                }
            }
            even = !even;
        }

        return true;
    }
}
