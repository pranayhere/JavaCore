package com.pranay.interview.trees;

public class SymmetricTree {
	static Node root;
	public static void main(String[] args) {
		SymmetricTree tree = new SymmetricTree();
		tree.root = new Node(314);
		tree.root.left = new Node(6);
		tree.root.right = new Node(6);
		tree.root.left.right = new Node(2);
		tree.root.right.left = new Node(2);
		tree.root.left.right.right = new Node(3);
		tree.root.right.left.left = new Node(3);

		boolean isSymmetric = isSymmetric(root);
		System.out.println("isSummetric : " + isSymmetric);
	}

	private static boolean isSymmetric(Node tree) {
		return tree == null || checkSymmetric(tree.left, tree.right);
	}

	private static boolean checkSymmetric(Node subtree0, Node subtree1) {
		if (subtree0 == null && subtree1 == null) {
			return true;
		}
		else if (subtree0 != null && subtree1 != null) {
			return subtree0.data == subtree1.data
					&& checkSymmetric(subtree0.left, subtree1.right)
					&& checkSymmetric(subtree0.right, subtree1.left);
		}
		return false;
	}


	private static boolean checkSymmetric2(Node subtree0, Node subtree1) {
	    if (subtree0 == null && subtree1 == null) {
	        return true;
        } else if (subtree0 != null && subtree1 != null) {
	        return subtree0.data == subtree1.data
                    && checkSymmetric2(subtree0.left, subtree1.right)
                    && checkSymmetric2(subtree0.right, subtree1.left);
        }
	    return false;
    }
}
