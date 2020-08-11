package com.pranay.interview.trees;

import java.util.HashMap;

public class PathSum3 {
    static Node root;
    public static void main(String[] args) {
        PathSum3 ps3 = new PathSum3();
        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        int sum = 8;
        int count = ps3.pathSum(root, sum);
        System.out.println("Count : " + count);
    }


    int count = 0;
    int k;
    HashMap<Integer, Integer> hm = new HashMap<>();

    private int pathSum(Node root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    private void preorder(Node node, int currSum) {
        if (node == null)
            return;

        currSum += node.data;

        if (currSum == k)
            count++;

        count += hm.getOrDefault(currSum - k, 0);
        hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);

        preorder(node.left, currSum);
        preorder(node.right, currSum);

        hm.put(currSum, hm.get(currSum) - 1);
    }
}
