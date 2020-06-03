package com.pranay.interview.LinkedList;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNodeInLinkedList {
    static ListNode head;
    public static void main(String[] args) {
        DeleteNodeInLinkedList list = new DeleteNodeInLinkedList();
        head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode delete = new ListNode(9);
        deleteNode(delete);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static void deleteNode(ListNode node) {
        ListNode headNode = head;
        ListNode prev = head;
        if (headNode.val == node.val) {
            headNode = headNode.next;
            head = headNode;
        }

        while (headNode != null) {
            if (headNode.val == node.val) {
                prev.next = headNode.next;
            }
            prev = headNode;
            headNode = headNode.next;
        }
    }
}
