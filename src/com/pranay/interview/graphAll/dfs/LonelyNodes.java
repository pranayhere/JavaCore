package com.pranay.interview.graphAll.dfs;

import com.pranay.GeeksForGeeks.Node;

import java.util.ArrayList;
import java.util.List;

public class LonelyNodes {
    static Node root;
    public static void main(String[] args) {
        LonelyNodes ln = new LonelyNodes();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);

        List<Integer> ans = getLonelyNodes(root);
        System.out.println("Lonely nodes are : " + ans);
    }

    private static List<Integer> getLonelyNodes(Node node) {
        List<Integer> ans = new ArrayList<>();
        dfs(node, ans);
        return ans;
    }

    private static void dfs(Node node, List<Integer> ans) {
        if (node == null)
            return;

        if (node.left == null && node.right != null)
            ans.add(node.right.data);
        else if (node.right == null && node.left != null)
            ans.add(node.left.data);

        dfs(node.left, ans);
        dfs(node.right, ans);
    }
}
