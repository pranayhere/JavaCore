package com.pranay.interview.trees;

public class CheckSubTree {
    static Node s;
    static Node t;
    public static void main(String[] args) {
        CheckSubTree st = new CheckSubTree();
        s = new Node(3);
        s.left = new Node(4);
        s.right = new Node(5);
        s.left.left = new Node(1);
        s.left.right = new Node(2);

        t = new Node(4);
        t.left = new Node(1);
        t.right = new Node(2);

        boolean isSubTree = isSubtree(s, t);
        System.out.println("Ans : " + isSubTree);
    }

    private static boolean isSubtree(Node s, Node t) {
        String tree1 = preorder(s);
        String tree2 = preorder(t);

        System.out.println(tree1);
        System.out.println(tree2);

        return tree1.contains(tree2);
    }

    private static String preorder(Node s) {
        if (s == null)
            return "null";
        return "#" + s.data + " " + preorder(s.left) + " " + preorder(s.right);
    }

}
