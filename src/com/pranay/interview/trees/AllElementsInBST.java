package com.pranay.interview.trees;

import com.pranay.interview.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AllElementsInBST {
    static TreeNode root1;
    static TreeNode root2;

    public static void main(String[] args) {
        AllElementsInBST aeb = new AllElementsInBST();
        root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        List<Integer> allElems = aeb.getAllElements(root1, root2);
        System.out.println("All Elements : " + allElems);
    }

    private List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> list1 = new ArrayDeque<>();
        inorder(root1, list1);

        Queue<Integer> list2 = new ArrayDeque<>();
        inorder(root2, list2);
        List<Integer> ans = merge(list1, list2);
        return ans;
    }

    private List<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        List<Integer> ans = new ArrayList<>();
        while (!q1.isEmpty() && !q2.isEmpty())
            ans.add(q1.peek() < q2.peek() ? q1.poll() : q2.poll());

        while (!q1.isEmpty())
            ans.add(q1.poll());

        while (!q2.isEmpty())
            ans.add(q2.poll());

        return ans;
    }

    private void inorder(TreeNode node, Queue<Integer> q) {
        if (node == null)
            return;

        inorder(node.left, q);
        q.offer(node.data);
        inorder(node.right, q);
    }



//    public void preorderExperimental(TreeNode root1, TreeNode root2, List<Integer> ans) {
//        if (root1 == null || root2 == null)
//            return;
//        preorder(root1.left, root2, ans);
//        preorder(root1, root2.left, ans);
//
//        if (root1.data < root2.data) {
//            ans.add(root1.data);
//            preorder(root1.right, root2, ans);
//        } else {
//            ans.add(root2.data);
//            preorder(root1, root2.right, ans);
//        }
//    }
}
