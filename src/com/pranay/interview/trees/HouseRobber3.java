package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class HouseRobber3 {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        int ans = rob(root);
        System.out.println("Ans : " + ans);
    }

    private static int rob(TreeNode root) {
        
        return 0;
    }
}
