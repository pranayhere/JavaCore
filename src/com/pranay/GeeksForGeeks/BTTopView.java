package com.pranay.GeeksForGeeks;
/*	
 *      1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
	Top view of the above binary tree is
	2 1 3 6
*/	

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

class QItem  {
	Node node;
	int hd; // horizontal distance
	public QItem(Node n, int h) {
		node = n;
		hd = h;
	}
}
public class BTTopView {
	Node root;
	public void printTopView() {
		if(root == null)
			return;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<QItem> Q = new LinkedList<QItem>();
		Q.add(new QItem(root, 0));

		while(!Q.isEmpty()) {
			QItem qi = Q.remove();
			int hd = qi.hd;
			Node n = qi.node;

		//  Top View	
			if(!map.containsKey(hd)) 
				map.put(hd, n.data);
			

		//`	Bottom View
		//	map.put(hd, n.data);

			if(n.left != null)
				Q.add(new QItem(n.left, hd-1));
			if(n.right != null)
				Q.add(new QItem(n.right, hd+1));
		}

		map.forEach((k, v) -> {
			System.out.print(v + " ");
		});
	}

	public static void main(String[] args) {
		BTTopView tree = new BTTopView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);

		System.out.println("Following are nodes in top view of Binary Tree");
		tree.printTopView();
	}
}
