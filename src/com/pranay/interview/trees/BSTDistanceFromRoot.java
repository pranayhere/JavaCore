package com.pranay.interview.trees;

public class BSTDistanceFromRoot {
	static Node root;

	private int distanceFromRoot(Node node, int key) {
		if (node.data == key)
			return 0;
		else if (key < node.data)
			return 1 + distanceFromRoot(node.left, key);
		return 1 + distanceFromRoot(node.right, key);
	}

	public static void main(String[] args) {
		BSTDistanceFromRoot tree = new BSTDistanceFromRoot();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int distance = tree.distanceFromRoot(root, 55);
		System.out.println("Distance(root, 10) " + distance);
	}
}

/**
 *           20
 *        8      22
 *     4    12
 *        10  14
 */