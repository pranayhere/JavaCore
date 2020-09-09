package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

public class SerializeDeserializeBST {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        SerializeDeserializeBST tree = new SerializeDeserializeBST();
        String str = tree.serialize(root);
        System.out.println("Serialize : " + str);
        TreeNode deserialize = tree.deserialize(str);
    }

    private String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    private TreeNode deserialize(String str) {
        TreeNode root = null;
        for (String s: str.split(",")) {
            if (s.length() > 0)
                root = buildBST(root, Integer.parseInt(s));
        }
        return root;
    }

    private TreeNode buildBST(TreeNode node, int val) {
        if (node == null)
            return new TreeNode(val);

        if (val < node.val)
            node.left = buildBST(node.left, val);
        else
            node.right = buildBST(node.right, val);

        return node;
    }
}