package com.pranay.interview.trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidBST {
	static Node root;
	public static void main(String[] args) {
		ValidBST tree = new ValidBST();
		tree.root = new Node(2);
		tree.root.left = new Node(5);
		tree.root.right = new Node(3);

		boolean isValid = isValidBST3(root);
		System.out.println(isValid);
	}

	private static boolean isValidBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		return isValidBST(node.left, min, node.data - 1) && isValidBST(node.right, node.data + 1, max);
	}

	private static boolean isValidBst2(Node node) {
		Stack<Node> stk = new Stack<>();
		double inorder = Integer.MIN_VALUE;

		while(!stk.isEmpty() || node != null) {
			while (node != null) {
				stk.push(node);
				node = node.left;
			}
			node = stk.pop();
			if (node.data <= inorder) return false;
			inorder = node.data;
			System.out.print(node.data + " ");
			node = node.right;
		}
		return true;
	}

	private static boolean isValidBST3(Node node) {
        List<Integer> nums = new ArrayList<>();
        inorder(node, nums);
        System.out.println(nums);
        for (int i = 0; i<nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
               return false;
            }
        }
        return true;
    }

    private static void inorder(Node node, List<Integer> nums) {
	    if (node == null) return;
	    inorder(node.left, nums);
	    nums.add(node.data);
	    inorder(node.right, nums);
    }


}
