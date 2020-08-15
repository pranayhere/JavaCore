package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class LongestConsecutiveSubsequenceInBT {
    static TreeNode root;

    public static void main(String[] args) {
        LongestConsecutiveSubsequenceInBT lcs = new LongestConsecutiveSubsequenceInBT();
        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        int size = lcs.longestConsecutive(root);
        System.out.println("Size : " + size);
    }

    int max = 0;

    private int longestConsecutive(TreeNode root) {
        traverse(root);
        return max;
    }

    class Result {
        TreeNode node;
        int inc;
        int dec;
    }

    private Result traverse(TreeNode node) {
        if (node == null)
            return null;

        Result left = traverse(node.left);
        Result right = traverse(node.right);

        Result curr = new Result();
        curr.node = node;
        curr.inc = 1;
        curr.dec = 1;

        if (left != null) {
            if (node.data - left.node.data == 1) {
                curr.inc = Math.max(curr.inc, left.inc + 1);
            }
            else if (node.data - left.node.data == -1) {
                curr.dec = Math.max(curr.dec, left.dec + 1);
            }
        }

        if (right != null) {
            if (node.data - right.node.data == 1) {
                curr.inc = Math.max(curr.inc, right.inc + 1);
            }
            else if (node.data - right.node.data == -1) {
                curr.dec = Math.max(curr.dec, right.dec + 1);
            }
        }

        max = Math.max(max, curr.inc + curr.dec - 1);
        return curr;
    }
}
