package com.pranay.interview.arrays.TreeBFS;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

import com.pranay.interview.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		List<List<Integer>> levels = zigZagLevelOrder(root);
		System.out.println(levels);
	}

	private static List<List<Integer>> zigZagLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		queue.add(root);
		queue.add(new TreeNode(Integer.MIN_VALUE));

		boolean flip = false;

		LinkedList<Integer> level = new LinkedList<>();

		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node.val != Integer.MIN_VALUE) {
				if (flip)
					level.addFirst(node.val);
				else
					level.addLast(node.val);

				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);

			} else {
				flip = !flip;
				ans.add(new ArrayList<>(level));
				level.clear();
				if (!queue.isEmpty())
					queue.add(new TreeNode(Integer.MIN_VALUE));
			}
		}
		return ans;
	}
}
