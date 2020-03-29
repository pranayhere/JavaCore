package com.pranay.interview.trees;

class BalanceStatusWithHeight {
	public boolean balanced;
	public int height;

	public BalanceStatusWithHeight(boolean balanced, int height) {
		this.balanced = balanced;
		this.height = height;
	}
}

public class BinaryTreeHeightBalanced {
	static Node root;

	public static void main(String[] args) {
		BinaryTreeHeightBalanced tree = new BinaryTreeHeightBalanced();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4); // try commenting from here, output should be true
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		boolean isBalanced = tree.isBalanced(root);
		System.out.println("IsBalanced : " +isBalanced);
	}

	private boolean isBalanced(Node root) {
		return checkBalanced(root).balanced;
	}

	private BalanceStatusWithHeight checkBalanced(Node root) {
		if (root == null) {
			return new BalanceStatusWithHeight(true, -1);
		}

		BalanceStatusWithHeight leftResult = checkBalanced(root.left);
		if (!leftResult.balanced) {
			return leftResult; //left subtree is not balanced
		}

		BalanceStatusWithHeight rightResult = checkBalanced(root.right);
		if (!rightResult.balanced) {
			return rightResult; //right subtree is not balanced
		}

		boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
		int height = Math.max(leftResult.height, rightResult.height) + 1;

		return new BalanceStatusWithHeight(isBalanced, height);
	}
}
