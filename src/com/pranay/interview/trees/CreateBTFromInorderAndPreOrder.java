package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBTFromInorderAndPreOrder {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        CreateBTFromInorderAndPreOrder bt = new CreateBTFromInorderAndPreOrder();
        TreeNode root = bt.buildTree(preorder, inorder);
        System.out.println(root);
    }

    int preIdx = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return dfs(0, inorder.length - 1);
    }

    public TreeNode dfs(int inLeft, int inRight) {
        if (inLeft == inRight)
            return null;

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        preIdx++;

        int splitIdx = idxMap.get(rootVal);

        root.left = dfs(inLeft, splitIdx);
        root.right = dfs(splitIdx + 1, inRight);
        return root;
    }
}
