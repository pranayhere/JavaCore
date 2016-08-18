package com.pranay.GeeksForGeeks;

public class BTisBalanced {
	static Node root;
	public BTisBalanced() {
		root = null;
	}
	public boolean isBalanced(Node node) {
		if(node == null)
			return true;
		int lh = height(node.left);
		int rh = height(node.right);
		
		return(Math.abs(lh-rh)<=1 
				&& isBalanced(node.left)
				&& isBalanced(node.right));
	}
	private int height(Node root) {
		if(root == null)
			return 0;
		return(1+Math.max(height(root.left), height(root.right)));
	}
	public static void main(String[] args) {
		BTisBalanced tree = new BTisBalanced();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
 
        if(tree.isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
	}
}
