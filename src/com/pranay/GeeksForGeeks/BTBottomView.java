package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class BTBottomView {
	Node root;
	public void printBottomView() {
		if (root == null)
			return;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<QItem> q = new LinkedList<QItem>();
		q.add(new QItem(root, 0));
		
		while (!q.isEmpty()) {
			QItem qi = q.remove();
			Node node = qi.node;
			int hd = qi.hd;
			
//			if (!map.containsKey(hd))
//				map.put(hd, node.data);
			
			map.put(hd, node.data);
			
			if (node.left != null)
				q.add(new QItem(node.left, hd-1));
			if (node.right != null)
				q.add(new QItem(node.right, hd+1));
		}
		map.forEach((k, v) -> {
			System.out.print(v + " ");
		});
	}
	
	public static void main(String[] args) {
		BTBottomView tree = new BTBottomView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);

		System.out.println("Following are nodes in top view of Binary Tree");
		tree.printBottomView();
	}

}
