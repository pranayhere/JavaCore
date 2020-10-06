package com.pranay.GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int x) { val = x; }
  }

public class MaxSumLevel {
    public static void main(String[] args) {
//[1,7,0,7,-8,null,null]
//        2
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        int maxSum = 0;
        int maxlevel = 0;

        int level = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (null == node) {
                if (!q.isEmpty()) {
                     q.offer(null);
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    maxlevel = level;
                }
                sum = 0;
                level++;
            } else {
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                sum += node.val;
            }
        }
        return maxlevel+1;
    }
}
