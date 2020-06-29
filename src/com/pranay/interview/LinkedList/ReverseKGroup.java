package com.pranay.interview.LinkedList;

public class ReverseKGroup {
    static ListNode head;
    public static void main(String[] args) {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;
        ListNode newHead = reverseKGroup(head, k);
        while(newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;

        while (count < k && ptr != null) {
            count++;
            ptr = ptr.next;
        }

        if (count == k) {
            ListNode reversedHead = reverseLinkedList(head, k);
            head.next = reverseKGroup(ptr, k);
            return reversedHead;
        }
        return head;
    }

    private static ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null;
        ListNode ptr = head;

        while (k > 0) {
            ListNode nextNode = ptr.next;

            ptr.next = newHead;
            newHead = ptr;

            ptr = nextNode;
            k--;
        }
        return newHead;
    }
}
