package com.pranay.interview.trees;

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		this.data = item;
		left = right = null;
	}
}

public class BSTLowestCommonAncestor {
	static Node root;

	private Node lca(Node node, int n1, int n2) {
		if (node == null)
			return null;
		if (node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);

		if (node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);

		return node;
	}

	private Node lca2(Node node, int n1, int n2) {
	    if (node == null) {
	        return null;
        }

	    if (node.data > n1 && node.data > n2) {
	        return lca2(node.left, n1, n2);
        }

	    if (node.data < n1 && node.data < n2) {
	        return lca2(node.right, n1, n2);
        }
	    return node;
    }

	public static void main(String[] args) {
		BSTLowestCommonAncestor tree = new BSTLowestCommonAncestor();

		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int a = Integer.MIN_VALUE;
		int n1 = 4, n2 = 14;
		Node t = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	}
}

/**
 *           20
 *        8      22
 *     4    12
 *        10  14
 */