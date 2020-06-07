package com.pranay.GeeksForGeeks;

/*
 *        12
       /     \
     10       30
            /    \
          25      40 
 */
public class BTRightView {
	static Node root;
	static int max_level = 0;
	
	public void rightView(Node node, int level) {
		if(node == null)
			return;
		if(max_level < level) {
			System.out.print(node.data+" ");
			max_level = level;
		}
		rightView(node.right, level+1);
		rightView(node.left, level+1);
		
	}
	public static void main(String[] args) {
		BTRightView tree = new BTRightView();
		tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
	
        tree.rightView(root, 1);
	}
}
