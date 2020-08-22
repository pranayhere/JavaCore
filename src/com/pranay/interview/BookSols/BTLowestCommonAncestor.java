package com.pranay.interview.BookSols;

public class BTLowestCommonAncestor {
    static Node root;
    public static void main(String[] args) {
        BTLowestCommonAncestor tree = new BTLowestCommonAncestor();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        Node lca = findLCA(root, 4, 12);
        System.out.println("LCA is : " + lca.val);
    }

    private static Node findLCA(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (node.val == n1 || node.val == n2)
            return node;

        Node left = findLCA(node.left, n1, n2);
        Node right = findLCA(node.right, n1, n2);

        if (left != null && right != null)
            return node;

        return left != null ? left : right;
    }
}
