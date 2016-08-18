package com.pranay.GeeksForGeeks;

public class BTkdistanceNodes {
	static Node root;
	private void printKDistance(Node node, int k){
		if(node == null)
			return ;
		if(k == 0) {
			System.out.print(node.data+" ");
			return;
		}
		else {
			printKDistance(node.left, k-1);
			printKDistance(node.right, k-1);
		}
	}
	public static void main(String[] args) {
		BTkdistanceNodes tree = new BTkdistanceNodes();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);
        
        tree.printKDistance(root, 2);
	}
}