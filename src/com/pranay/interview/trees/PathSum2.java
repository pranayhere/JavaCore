package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        PathSum2 ps2 = new PathSum2();
        List<List<Integer>> res = ps2.pathSum(root, targetSum);
        System.out.println(res);
    }

    List<List<Integer>> ans = new ArrayList<>();
    private List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode node, int targetSum, int currSum, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (currSum + node.val == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, targetSum, currSum + node.val, path);
            dfs(node.right, targetSum, currSum + node.val, path);
        }

        path.remove(path.size() - 1);
    }
}
