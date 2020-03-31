package com.pranay.interview.trees;

import java.util.ArrayList;

public class LowestCommonAncestor {
	static Node root;


	private static int findLCA(Node root, int n1, int n2) {
		ArrayList<Integer> path1 = new ArrayList<>();
		ArrayList<Integer> path2 = new ArrayList<>();
		boolean hasPath1 =  findPath(root, n1, path1);
		boolean hasPath2 = findPath(root, n2, path2);

		System.out.println(path1 + " \n" +path2);

		System.out.println();
		if (!hasPath1 || !hasPath2) {
			return -1;
		}

		int i;
		for (i=0; i<path1.size() && i<path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}
		}
		return path1.get(i-1);
	}

	private static boolean findPath(Node root, int n, ArrayList<Integer> path) {
		if (root == null) {
			return false;
		}

		path.add(root.data);
		if (root.data == n) {
			return true;
		}
		if (findPath(root.left, n, path) || findPath(root.right, n, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

	public static void main(String[] args) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int lca = findLCA(root, 4, 14);
		System.out.println("LCA : " +lca);
	}

}
