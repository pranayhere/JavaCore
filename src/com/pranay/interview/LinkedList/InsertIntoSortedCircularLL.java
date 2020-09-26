package com.pranay.interview.LinkedList;

public class InsertIntoSortedCircularLL {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    static Node head;
    public static void main(String[] args) {
        head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1, head);

        int insertVal = 2;
        Node ans = insert(head, insertVal);

        Node tmp = ans;
        while (tmp.next != null && tmp.next != head) {
            System.out.println(tmp.val + " -> ");
            tmp = tmp.next;
        }
        System.out.print(tmp.val);
    }

    public static Node insert(Node head, int insertVal) {
        Node node = head;

        if (node == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        while (node.next != null && node.next != head) {
            if (node.val < insertVal && ((node.next.val > insertVal) || (node.next.val < node.val))) {
                Node newNode = new Node(insertVal);
                newNode.next = node.next;
                node.next = newNode;

                return head;
            } else {
                node = node.next;
            }

            if (node.next == head && node.val < insertVal) {
                Node newNode = new Node(insertVal);
                newNode.next = node.next;
                node.next = newNode;

                return head;
            }

            node = node.next;
            Node newNode = new Node(insertVal);
            newNode.next = node.next;
            node.next = newNode;
        }
        return head;
    }
}
