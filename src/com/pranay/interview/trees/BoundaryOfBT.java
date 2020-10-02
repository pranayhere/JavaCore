package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 545. Boundary of Binary Tree
 * https://leetcode.com/problems/boundary-of-binary-tree
 *
 *     ____1_____
 *    /          \
 *   2            3
 *  / \          /
 * 4   5        6
 *    / \      / \
 *   7   8    9  10
 *
 *   ans : [1,2,4,7,8,9,10,6,3]
 */
public class BoundaryOfBT {
    static TreeNode root;
    public static void main(String[] args) {
        BoundaryOfBT tree = new BoundaryOfBT();
        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        List<Integer> list = tree.boundaryOfBinaryTree(root);
        System.out.println("List : " + list);
    }

    List<Integer> nodes = new ArrayList<>(1000);
    private List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return nodes;

        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        
        return nodes;
    }

    private void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;

        nodes.add(root.val);
        if (root.left == null)
            leftBoundary(root.right);
        else
            leftBoundary(root.left);
    }

    private void rightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;

        if (root.right == null)
            rightBoundary(root.left);
        else
            rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }

    private void leaves(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }

        leaves(root.left);
        leaves(root.right);
    }
}
