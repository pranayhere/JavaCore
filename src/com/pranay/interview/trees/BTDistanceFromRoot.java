package com.pranay.interview.trees;

public class BTDistanceFromRoot {
	static Node root;

	private int findDistance(Node node, int x) {
		if (node == null)
			return -1;

		int dist = -1;

		if ((node.data == x) ||
				(dist = findDistance(node.left, x)) >= 0 ||
				(dist = findDistance(node.right, x)) >= 0)
			return dist + 1;

		return dist;
	}

	public static void main(String[] args) {
		BTDistanceFromRoot tree = new BTDistanceFromRoot();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int distance = tree.findDistance(root, 14);
		System.out.println("distance(root, 14) " + distance);
	}
}

/**
 *           20
 *        8      22
 *     4    12
 *        10  14
 */