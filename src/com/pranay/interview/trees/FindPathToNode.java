package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.List;

public class FindPathToNode {
	static Node root;

	private static void findPath(Node root, int n) {
		ArrayList<Integer> path = new ArrayList<>();
		if (hasPath(root, n, path)) {
			System.out.println(path);
		} else {
			System.out.println("No path");
		}

	}

	private static boolean hasPath(Node root, int n, ArrayList<Integer> path) {
		if (root == null) {
			return false;
		}

		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (hasPath(root.left, n, path) || hasPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size() - 1);
		return false;
	}


	public static void main(String[] args) {
		FindPathToNode tree = new FindPathToNode();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		findPath(root, 182);
	}


}
