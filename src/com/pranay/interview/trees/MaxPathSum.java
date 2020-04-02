package com.pranay.interview.trees;

public class MaxPathSum {
	static Node root;
	private static int max_sum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		MaxPathSum tree = new MaxPathSum();
		tree.root = new Node(-10);
		tree.root.left = new Node(9);
		tree.root.right = new Node(20);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(7);

		int maxSum = maxPathSum(root);
		System.out.println(max_sum); // print global variable
	}

	public static int maxPathSum(Node node) {
		max_sum = Integer.MIN_VALUE;
		findMaxPath(node);
		return max_sum;
	}

	public static int findMaxPath(Node node) {
		if (node == null) return 0;
		int left = Math.max(0, findMaxPath(node.left));
		int right = Math.max(0, findMaxPath(node.right));
		max_sum = Math.max(max_sum, left + right + node.data);
		return Math.max(left, right) + node.data;
	}
}
