package com.pranay.interview.trees;

public class LargestCompleteSubtree {
	static Node root;
	public static void main(String[] args) {
		LargestCompleteSubtree tree = new LargestCompleteSubtree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4); // try commenting from here, output should be true
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int size = largestCompleteSubtree(root);
	}

	private static int largestCompleteSubtree(Node root) {
		return 0;
	}
}
