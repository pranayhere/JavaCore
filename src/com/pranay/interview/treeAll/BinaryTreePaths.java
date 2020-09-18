package com.pranay.interview.treeAll;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths btp = new BinaryTreePaths();
        List<String> ans = btp.binaryTreePaths(root);
        System.out.println("Ans : " + ans);
    }

    public List<String> binaryTreePaths(TreeNode node) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(node, new ArrayList<>(), paths);

        System.out.println("paths : " + paths);
        List<String> ans = new ArrayList<>();
        for (List<Integer> path: paths) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                str.append(path.get(i)).append("->");
            }
            str.append(path.get(path.size() - 1));
            ans.add(str.toString());
        }
        return ans;
    }

    public void dfs(TreeNode node, List<Integer> curr, List<List<Integer>> paths) {
        if (node == null)
            return;

        curr.add(node.val);

        if (node.left == null && node.right == null)
            paths.add(new ArrayList<>(curr));

        dfs(node.left, curr, paths);
        dfs(node.right, curr, paths);

        curr.remove(curr.size() - 1);
    }
}
