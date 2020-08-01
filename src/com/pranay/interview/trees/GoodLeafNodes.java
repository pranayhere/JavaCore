package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.List;

public class GoodLeafNodes {
    static Node root;

    public static void main(String[] args) {
        GoodLeafNodes gln = new GoodLeafNodes();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int distance = 3;
        int count = gln.countPairs(root, distance);
        System.out.println("Count : " + count);
    }

    int ans = 0;

    public int countPairs(Node root, int distance) {
        ans = 0;
        dfs(root, distance);
        return ans;
    }

    List<Integer> dfs(Node root, int distance) {
        if (root == null)
            return new ArrayList<Integer>();

        if (root.left == null && root.right == null) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }

        List<Integer> L = dfs(root.left, distance);
        List<Integer> R = dfs(root.right, distance);
        for (int x : L) {
            for (int y : R) {
                if (x + y + 2 <= distance) {
                    ans++;
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int x : L) ret.add(x + 1);
        for (int x : R) ret.add(x + 1);
        return ret;
    }


}
