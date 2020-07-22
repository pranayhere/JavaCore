package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. Delete Nodes And Return Forest
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 *
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 * Example 1:
 *            1
 *          /  \
 *         2    3
 *       / \   / \
 *      4  5  6  7
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 */

public class DeleteNodesAndReturnForest {
    static Node root;
    public static void main(String[] args) {
        DeleteNodesAndReturnForest dnrf = new DeleteNodesAndReturnForest();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int[] toDelete = {3,5};
        List<Node> forest = dnrf.delNodes(root, toDelete);
        System.out.println(forest);
    }

    List<Node> res = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();

    private List<Node> delNodes(Node root, int[] toDel) {
//        res.add(root);
        for (int node: toDel)
            hs.add(node);

        dfs2(root);
        return res;
    }

    private Node dfs(Node node) {
        if (node == null)
            return null;

        node.left = dfs(node.left);
        node.right = dfs(node.right);

        if (hs.contains(node.data)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }

        return node;
    }

    private Node dfs2(Node node) {
        if (node == null)
            return null;

        if (hs.contains(node.data)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
        }

        node.left = dfs2(node.left);
        node.right = dfs2(node.right);

        return hs.contains(node.data) ? null : node;
    }
}
