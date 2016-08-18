package com.pranay.GeeksForGeeks;

public class BSTPaths {
	static Node root;
	public BSTPaths() {
		root = null;
	}

	void printPaths(Node node) {
		int path[] = new int[1000];
		printPathRecr(node, path, 0, 0, 8);
	}

	private void printPathRecr(Node node, int[] path, int pathLen, int sum, int k) {
		if(node == null) 
			return;
		path[pathLen] = node.data;
		sum += node.data;
		pathLen++;

		if(node.left == null && node.right == null) {
			if(sum == k)
				printArray(path, pathLen);
		}
		else {
			printPathRecr(node.left, path,pathLen, sum, k);
			printPathRecr(node.right, path,pathLen, sum, k);

		}
	}

	private void printArray(int[] path, int pathLen) {
	//	int sum = 0;
		for(int i=0; i<pathLen; i++) {
	//		sum += path[i];
			System.out.print(path[i]+" ");
		}
	//	System.out.print("sum of path : "+sum);
		System.out.println("");
	}

	public static void main(String[] args) {
		BSTPaths tree = new BSTPaths();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		tree.printPaths(root);
	}
}