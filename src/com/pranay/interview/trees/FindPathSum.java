package com.pranay.interview.trees;

public class FindPathSum {
	static Node root;

	public static void main(String[] args) {
		FindPathSum tree = new FindPathSum();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int partialSum = 0;
		int targetSum = 42;
		boolean exist = findPathSum(root, partialSum, targetSum);
		System.out.println("path with given sum exists? : " + exist);
	}

	private static boolean findPathSum(Node node, int partialSum, int targetSum) {
		if (node == null) {
			return false;
		}

		partialSum += node.data;
		if (node.left == null && node.right == null) {
			return targetSum == partialSum;
		}

		return findPathSum(node.left, partialSum, targetSum) || findPathSum(node.right, partialSum, targetSum);
	}
}
