package com.pranay.interview.trees;

public class BTLowestCommonAncestor {
	static Node root;

	private Node findLCA(Node node, int n1, int n2) {
		if (node == null)
			return null;

		if (node.data == n1 || node.data == n2)
			return node;

		Node leftLCA = findLCA(node.left, n1, n2);
		Node rightLCA = findLCA(node.right, n1, n2);

		if (leftLCA != null && rightLCA != null) {
			return node;
		}

		return leftLCA != null ? leftLCA : rightLCA;
	}

	public static void main(String[] args) {
		BTLowestCommonAncestor tree = new BTLowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		Node node = tree.findLCA(root, 8, 6);
		System.out.println("LCA(4, 5) " + node.data);
	}
}

/**
 *                1
 *            2       3
 *        4     5  6     7
 *     8
 */