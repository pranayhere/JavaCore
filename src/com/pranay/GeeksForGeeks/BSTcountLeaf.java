package com.pranay.GeeksForGeeks;

class Node1 {
	int data;
	Node1 left, right;
	public Node1(int data) {
		this.data = data;
		left = right = null;
	}
}
public class BSTcountLeaf {
	static Node1 root;
	public BSTcountLeaf() {
		root = null;
	}
	
	public int countLeaf(Node1 node) {
		if(node == null)
			return 0;
		else if(node.left == null && node.right == null)
			return 1;
		else {
			return (countLeaf(node.left) + countLeaf(node.right));
		}
	}
	
	public static void main(String[] args) {
		BSTcountLeaf tree = new BSTcountLeaf();
		tree.root = new Node1(1);
		tree.root.left = new Node1(2);
		tree.root.left.left = new Node1(4);
		tree.root.left.right = new Node1(5);
		tree.root.right = new Node1(3);
		
		System.out.println(tree.countLeaf(root));
	}
}
