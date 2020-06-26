package com.pranay.interview.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *             20
 *           /   \
 *          8     22
 *        /  \    / \
 *       4   12  10  14
 */
public class SerializeDeserializeBinaryTree {
    static Node root;
    public static void main(String[] args) {
        SerializeDeserializeBinaryTree tree = new SerializeDeserializeBinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        String serialized = serialize(root);
        System.out.println(serialized);

        Node deserialized = deserialize(serialized);
        System.out.println("printing");
    }

    private static String serialize(Node root) {
        String res = "";
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur == null) {
                    res += "null,";
                } else {
                    res = res + String.valueOf(cur.data) + ",";
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("null")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i<nodes.length; i++) {
            Node parent = q.poll();

            if (!nodes[i].equals("null")) {
                parent.left = new Node(Integer.parseInt(nodes[i]));
                q.add(parent.left);
            }
            i++;
            if (!nodes[i].equals("null")) {
                parent.right = new Node(Integer.parseInt(nodes[i]));
                q.add(parent.right);
            }
        }
        return root;
    }
}
