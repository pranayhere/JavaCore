package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
    static Node root;
    public static void main(String[] args) {
        SumRootToLeaf tree = new SumRootToLeaf();
        root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(0);
        root.left.left = new Node(5);
        root.left.right = new Node(1);

//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);

        int sum = tree.sumNumbers(root);
        System.out.println("Sum : " + sum);
    }

    private int sumNumbers(Node root) {
        // all paths from root to leaf
        // sum of all paths

        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(root, allPaths, new ArrayList<Integer>());
        System.out.println(allPaths);

        int totalSum = 0;
        for (List<Integer> path : allPaths) {
            String str = "";
            for (int i = 0; i<path.size(); i++) {
                str += path.get(i);
            }
            int num = Integer.parseInt(str);
            System.out.println("Num : " + num);
            totalSum += num;
        }
        return totalSum;
    }

    private void dfs(Node root, List<List<Integer>> allPaths, ArrayList<Integer> currPath) {
        if (root == null) {
            return;
        }
        currPath.add(root.data);

        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currPath));
        }

        dfs(root.left, allPaths, currPath);
        dfs(root.right, allPaths, currPath);
        currPath.remove(currPath.size() - 1);
    }
}
