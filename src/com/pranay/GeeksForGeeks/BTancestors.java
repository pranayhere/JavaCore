package com.pranay.GeeksForGeeks;

public class BTancestors {
	static Node root;
	public BTancestors() {
		root = null;
	}
	public boolean printAncsetors(Node node, int target) {
		if(node == null)
			return false;
		if(node.data == target)
			return true;
		if(printAncsetors(node.left, target) || printAncsetors(node.right, target)) {
			System.out.print(node.data+" ");
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		BTancestors tree = new BTancestors();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        
        tree.printAncsetors(root, 7);
	}
}