package com.pranay.Leetcode30days;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class DiameterOfBinaryTree {
	static Node root;

	static int ans;

	private static int diameterOfTree(Node node) {
		ans = 1;
		depth(node);
		return ans - 1;
	}

	public static int depth(Node node) {
		if (node == null) {
			return 0;
		}

		int L = depth(node.left);
		int R = depth(node.right);
		ans = Math.max(ans, L + R + 1);
		return Math.max(L, R) + 1;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.left.left.left = new Node(5);
		tree.root.left.right.right = new Node(7);
		tree.root.left.right.right.right = new Node(8);

		int diameter = diameterOfTree(root);
		System.out.println("Diameter : " + diameter);
	}
}
