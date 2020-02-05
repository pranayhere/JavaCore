package com.pranay.interview.arrays.TreeBFS;

import com.pranay.interview.common.TreeNode;

// 102. Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> levels = levelOrder(root);
		System.out.println(levels);
	}

	private static List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();

		queue.add(root);
		queue.add(new TreeNode(Integer.MIN_VALUE));

		List<Integer> level = new ArrayList<>();

		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node.data != Integer.MIN_VALUE) {
				level.add(node.data);
			} else {
				ans.add(new ArrayList<>(level));
				level.clear();
				if (!queue.isEmpty())
					queue.add(new TreeNode(Integer.MIN_VALUE));
			}
			if (node.left != null) queue.add(node.left);
			if (node.right != null) queue.add(node.right);
		}
		Collections.reverse(ans);
		return ans;
	}
}
