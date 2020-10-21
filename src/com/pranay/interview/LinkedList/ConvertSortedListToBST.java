package com.pranay.interview.LinkedList;

import com.pranay.interview.common.TreeNode;

public class ConvertSortedListToBST {
    static ListNode head;
    public static void main(String[] args) {
        head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        System.out.println("Root : " + root);
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode mid = findMiddleElement(head);

        TreeNode node = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid)
            return node;

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private static ListNode findMiddleElement(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
}
