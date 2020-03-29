package com.pranay.interview.trees;

import java.util.Stack;

public class BinaryTreeTraversalIterative {
	static Node root;

	public static void main(String[] args) {
		BinaryTreeTraversalIterative tree = new BinaryTreeTraversalIterative();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		preOrder(root);
		inOrder(root);

	}

	private static void preOrder(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty()) {
			Node n = stack.pop();
			System.out.print(n.data + " ");
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}

	private static void inOrder(Node node) {
		if (root == null) {
			return;
		}

		Stack<Node> stk = new Stack<>();
		Node curr = node;

		while (!stk.empty()) {
			while (curr != null) {
				stk.push(curr);
				curr = curr.left;
			}
			curr = stk.pop();
			System.out.println(curr);
			curr = curr.right;
		}
	}


}
