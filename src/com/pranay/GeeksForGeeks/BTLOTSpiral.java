package com.pranay.GeeksForGeeks;

public class BTLOTSpiral {
	static Node root;
	public BTLOTSpiral() {
		root = null;
	}
	void printSpiral(Node node) {
		int h = height(node);
		boolean itr = true;
		for(int i=1; i<=h; i++) {
			printGivenLevel(node, i, itr);
			System.out.println();
	//		itr = !itr;
		}
	}
	private int height(Node node) {
		if(node == null)
			return 0;
		else {
			int lheight = height(node.left);
			int rheight = height(node.right);

			if(lheight > rheight)
				return lheight+1;
			else 
				return rheight+1;
		}
	}

	private void printGivenLevel(Node node, int level, boolean itr) {
		if(node == null)
			return;
		else if(level == 1)
			System.out.print(node.data+" ");
		else if(level > 1){
			if(itr != false) {
				printGivenLevel(node.left, level-1 , itr);
				printGivenLevel(node.right, level-1, itr);
			}
			else {
				printGivenLevel(node.right, level-1, itr);
				printGivenLevel(node.left, level-1, itr);				
			}
		}
	}

	public static void main(String[] args) {
		BTLOTSpiral tree = new BTLOTSpiral();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);
		System.out.println("Spiral order traversal of Binary Tree is ");

		tree.printSpiral(root);
	}
}
