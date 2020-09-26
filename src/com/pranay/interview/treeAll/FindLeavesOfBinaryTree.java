package com.pranay.interview.treeAll;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 366. Find Leaves of Binary Tree
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 *
 * Logical Thinking
 * We define height of a node as its distance (1 based) to the leaves of BT. For example,
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * height(4) = height(5) = height(3) = 1,
 * height(2) = 2,
 * height(1) = 3.
 * getHeight() helps us get the height of each node and map height to a list of nodes' values in heightToNodes. And we build the result list accordingly.io
 */
public class FindLeavesOfBinaryTree {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindLeavesOfBinaryTree leavesOfBt = new FindLeavesOfBinaryTree();
        List<List<Integer>> ans = leavesOfBt.findLeaves(root);
        System.out.println("Ans : " + ans);
    }

    Map<Integer, List<Integer>> hm = new HashMap<>();
    int maxheight;

    private List<List<Integer>> findLeaves(TreeNode root) {
        maxheight = 0;
        List<List<Integer>> res = new ArrayList<>();
        height(root);

        for (int i = 0; i < maxheight; i++) {
            res.add(hm.get(i + 1));
        }
        return res;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        hm.computeIfAbsent(currHeight, k -> new ArrayList<>()).add(node.val);
        maxheight = Math.max(maxheight, currHeight);
        return currHeight;
    }
}
