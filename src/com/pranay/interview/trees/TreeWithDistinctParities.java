package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeWithDistinctParities {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeWithDistinctParities tdp = new TreeWithDistinctParities();
        int count = tdp.distinctParities(root);
        System.out.println(root);
        System.out.println("count : " + count);
    }

    int count = 0;
    private int distinctParities(TreeNode root) {
        sumTree(root);
        return count;
    }

    private int sumTree(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        if (root.left != null && root.right != null) {
            if ((leftSum % 2) + (rightSum % 2) == 1)
                count++;
        }

        return leftSum + rightSum + root.val;

    }
}
