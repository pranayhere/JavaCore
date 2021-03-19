package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBTFromPostOrderAndInOrder {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        CreateBTFromPostOrderAndInOrder bt = new CreateBTFromPostOrderAndInOrder();
        TreeNode root = bt.buildTree(inorder, postorder);
        System.out.println("Ans : " + root);
    }

    int postIdx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        postIdx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++)
            idxMap.put(inorder[i], i);

        return dfs(0, inorder.length);
    }

    public TreeNode dfs(int inLeft, int inRight) {
        if (inLeft == inRight)
            return null;

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        int splitIdx = idxMap.get(rootVal);

        root.right = dfs(splitIdx + 1, inRight);
        root.left = dfs(inLeft, splitIdx);
        return root;
    }
}
