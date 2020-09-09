package com.pranay.interview.graphAll.dfs;

import com.pranay.GeeksForGeeks.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DeepestLeaveSum {
    static Node root;
    public static void main(String[] args) {
        DeepestLeaveSum dls = new DeepestLeaveSum();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);

        int sum = dls.deepestLeavesSum(root);
        System.out.println("Sum of Deepest nodes : " + sum);
    }

    TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
    private int deepestLeavesSum(Node root) {
        dfs(root, 1);
//        System.out.println("Map : " + tm);
        List<Integer> deepestNodes = tm.get(tm.lastKey());
        int sum = 0;
        for (int n: deepestNodes)
            sum += n;
        return sum;
    }

    private void dfs(Node node, int depth) {
        if (node == null)
            return;

        tm.computeIfAbsent(depth, k -> new ArrayList<>()).add(node.data);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
