package com.pranay.GeeksForGeeks;

import com.pranay.GeeksForGeeks.BinarySearchTree.Node;

class BST {
	class Node {
		int key;
		Node left, right;
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
	Node root;
	Node pre;
	Node suc;
	
	public BST() {
		root = null;
		pre = null;
		suc = null;
	}
	
	void insert(int key) {
		root = insert(root, key);
	}
	
	void findPreSuc(int key) {
		findPreSuc(root, pre, suc, key);
		if(pre != null)
			System.out.println("Predecessor is : " + pre.key);
		else
			System.out.println("No Predecessor");
		
		if(suc != null)
			System.out.println("Successor is : " + suc.key);
		else
			System.out.println("No Successor");
	}
	
	Node insert(Node root, int key) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		if(key < root.key)
			root.left = insert(root.left, key);
		else if(key > root.key)
			root.right = insert(root.right, key);
		return root;
	}
	
	void findPreSuc(Node root, Node pre, Node suc, int key) {
		if(root == null)
			return;
		
		if(root.key == key) {
			if(root.left != null) {
				Node temp = root.right;
				while(temp.right != null) {
					temp = temp.right;
				}
				pre = temp;
			}
			
			if(root.right != null) {
				Node temp = root.left;
				while(temp.left != null) {
					temp = temp.left;
				}
				suc = temp;
			}
			return;
		}
		
		if(root.key > key) {
			suc = root;
			findPreSuc(root.left, pre, suc, key);
		}
		else {
			pre = root;
			findPreSuc(root.right, pre, suc, key);
		}
	}
}

public class InorderPreSuc {
	
	public static void main(String[] args) {
		int key = 60;
		BST tree = new BST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		tree.findPreSuc(key);
	}
	
}
