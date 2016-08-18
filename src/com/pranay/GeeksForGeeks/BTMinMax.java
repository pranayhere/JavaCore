package com.pranay.GeeksForGeeks;
/*
 *        12
       /     \
     10       30
            /    \
          25      40 
 */
public class BTMinMax {
	static Node root;
	int findMax(Node node) {
		if(node == null)
			return 0;
		
		int res = node.data;
		int lres = findMax(node.left);
		int rres = findMax(node.right);
		
		if(lres > res)
			res = lres;
		if(rres > res)
			res = rres;
		return res;
	}
	public static void main(String[] args) {
		BTMinMax tree = new BTMinMax();
		tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(60);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        
        int max = tree.findMax(root);
        System.out.println(max);
	}
}
