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
		if (node == null) return 0;
		int left_gain = Math.max(maxPathSum(node.left), 0);
		int right_gain = Math.max(maxPathSum(node.right), 0);
		int price_newpath = node.data + left_gain + right_gain;
		max_sum = Math.max(max_sum, price_newpath);
		return node.data + Math.max(left_gain, right_gain);
	}
}
