package com.pranay.Leetcode31DaysOfMay;

import com.pranay.GeeksForGeeks.Node;

public class BSTfromPreorder {
    int idx = 0;
    int[] preorder;
    int n;

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        BSTfromPreorder tree = new BSTfromPreorder();
        Node root = tree.bstFromPreorder(preorder);
    }

    private Node bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        n = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Node helper(int lower, int upper) {
        if (idx == n)
            return null;

        int val = preorder[idx];
        if (val < lower || val > upper)
            return null;

        idx++;
        Node root = new Node(val);
        root.left = helper(lower, val);
        root.right = helper(val, upper);
        return root;
    }
}
