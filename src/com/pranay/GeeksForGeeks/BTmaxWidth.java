package com.pranay.GeeksForGeeks;

public class BTmaxWidth {
	static Node root;
	public BTmaxWidth() {
		root = null;
	}
	int getMaxWidth(Node node) {
		int width;
		int h = height(node);
		int count[] = new int[h];
		int level = 0;
		getMaxWidthRec(node, count, level);
		return getMax(count);
	}
	private void getMaxWidthRec(Node node, int[] count, int level) {
		if(node != null) {
			count[level]++;
			getMaxWidthRec(node.left, count, level+1);
			getMaxWidthRec(node.right, count, level+1);
		}
	}
	private int height(Node node) {
		if(node == null)
			return 0;
		else {
			int lheight = height(node.left);
			int rheight = height(node.right);
			
			return(1 + Math.max(lheight, rheight));
		}
	}

	private int getMax(int[] count) {
		int max = 0;
		for (int i = 0; i < count.length; i++) {
			if(count[i]> max)
				max = count[i];
		}
		return max;
	}
	public static void main(String[] args) {
		BTmaxWidth tree = new BTmaxWidth();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
 
        System.out.println("Maximum width is " + tree.getMaxWidth(root));
	}
}
