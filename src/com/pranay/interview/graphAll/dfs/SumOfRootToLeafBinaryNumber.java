package com.pranay.interview.graphAll.dfs;
import com.pranay.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumber {
    static TreeNode root;

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumber rtl = new SumOfRootToLeafBinaryNumber();
        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        int sum = rtl.sumRootToLeaf(root);
        System.out.println("Sum : " + sum);
    }

    private int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list, "");

        int sum = 0;
        for (String bin: list) {
            sum += Integer.parseInt(bin,2);
        }
        return sum;
    }

    public void dfs(TreeNode node, List<String> list, String curr) {
        if (node == null)
            return;

        if (node.left == null && node.right == null)
            list.add(curr + node.val);

        dfs(node.left, list, curr + node.val);
        dfs(node.right, list, curr + node.val);
    }
}
