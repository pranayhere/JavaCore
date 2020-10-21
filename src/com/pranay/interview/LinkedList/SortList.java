package com.pranay.interview.LinkedList;

public class SortList {
    static ListNode head;
    public static void main(String[] args) {
        head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);

        ListNode sorted = sortList(head);
        System.out.println(sorted);
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 1. cut the list in two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // 2. divide each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // merge l1 and l2
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }
}