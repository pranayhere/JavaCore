package com.pranay.GeeksForGeeks;

public class BTchildSum {
	static Node root;
	public BTchildSum() {
		root = null;
	}
	private boolean isSumProperty(Node node) {
		int left_data = 0, right_data = 0;
		if(node == null || (node.left == null && node.right == null))
			return true;
		else {
			if(node.left != null)
				left_data = node.left.data;
			if(node.right != null)
				right_data = node.right.data;
			return((node.data == left_data + right_data)
					&&isSumProperty(node.left)
					&&isSumProperty(node.right));
		}
	}
	public static void main(String[] args) {
		BTchildSum tree = new BTchildSum();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(2);

		if (tree.isSumProperty(root))
			System.out.println("The given tree satisfies children"
					+ " sum property");
		else
			System.out.println("The given tree does not satisfy children"
					+ " sum property");
	}
}
