package com.pranay.interview.trees;

public class SumTree {
	static Node root;
	public static void main(String[] args) {
		SumTree tree = new SumTree();
		tree.root = new Node(314);
		tree.root.left = new Node(6);
		tree.root.right = new Node(6);
		tree.root.left.right = new Node(2);
		tree.root.right.left = new Node(2);
		tree.root.left.right.right = new Node(3);
		tree.root.right.left.left = new Node(3);

		toSumTree(root);
		printInorder(root);
	}

	private static void printInorder(Node node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	private static int toSumTree(Node root) {
		if (root == null)
			return 0;

		int currData = root.data;
		root.data = toSumTree(root.left) + toSumTree(root.right);

		return root.data + currData;
	}
}
