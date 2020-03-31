package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ValidBST {
	static Node root;
	public static void main(String[] args) {
		ValidBST tree = new ValidBST();
		tree.root = new Node(2);
		tree.root.left = new Node(5);
		tree.root.right = new Node(3);

		boolean isValid = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//		boolean isValid2 = isValidBst2(root);
		System.out.println(isValid);
//		System.out.println("---------");
//		System.out.println(isValid2);
	}

	private static boolean isValidBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		return isValidBST(node.left, min, node.data - 1) && isValidBST(node.right, node.data + 1, max);
	}

	private static boolean isValidBst2(Node node) {
		Stack<Node> stk = new Stack<>();
		double inorder = Integer.MIN_VALUE;

		while(!stk.isEmpty() || node != null) {
			while (node != null) {
				stk.push(node);
				node = node.left;
			}
			node = stk.pop();
			if (node.data <= inorder) return false;
			inorder = node.data;
			System.out.print(node.data + " ");
			node = node.right;
		}
		return true;
	}
}
