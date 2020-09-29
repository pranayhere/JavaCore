package com.pranay.interview.LinkedList;

public class ReverseLinkedList {
    static ListNode node;

    public static void main(String[] args) {
        node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode newNode = reverseList(node);
        while (newNode != null) {
            System.out.println(newNode.val + "->");
            newNode = newNode.next;
        }
    }

    public static ListNode reverseList(ListNode node) {
        if (node == null)
            return null;

        ListNode curr = node;
        ListNode revNode = reverseList(node.next);
        
        System.out.println(curr.val);
        

        return curr;
    }
}
