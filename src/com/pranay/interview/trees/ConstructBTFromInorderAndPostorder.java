package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.HashMap;

public class ConstructBTFromInorderAndPostorder {
    public static void main(String[] args) {
        ConstructBTFromInorderAndPostorder tree = new ConstructBTFromInorderAndPostorder();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = tree.buildTree(inorder, postorder);
    }

    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    private TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        for (int i = 0; i < inorder.length; i++)
            hm.put(inorder[i], i);

        return buildTreeInPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeInPost(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (ps > pe || is > ie)
            return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);

        TreeNode leftChild = buildTreeInPost(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1);
        TreeNode rightChild = buildTreeInPost(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }
}
