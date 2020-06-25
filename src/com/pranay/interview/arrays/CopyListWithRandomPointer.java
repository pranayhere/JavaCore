package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    static Node node;
    public static void main(String[] args) {
        CopyListWithRandomPointer rp = new CopyListWithRandomPointer();
        node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);

        node.random = null;
        node.next.random = node;
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;

        Node headNode = copyRandomListRecursive(node);
        System.out.println(headNode);
    }

    private static Map<Node, Node> hm = new HashMap<>();

    private static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node node = head;
        Map<Node, Node> hm = new HashMap<>();

        while (node != null) {
            hm.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        Node newNode = new Node(node.val);
        Node newHead = newNode;
        while (node.next != null) {
            newNode.next = hm.get(node.next);
            newNode.random = hm.get(node.random);
            node = node.next;
            newNode = newNode.next;
        }

        return newHead;
    }

    private static Node copyRandomListRecursive(Node head) {
        if (head == null) {
            return null;
        }

        if (hm.containsKey(head)) {
            return hm.get(head);
        }

        Node node = new Node(head.val);
        hm.put(head, node);

        node.next = copyRandomListRecursive(head.next);
        node.random = copyRandomListRecursive(head.random);
        return node;
    }
}
