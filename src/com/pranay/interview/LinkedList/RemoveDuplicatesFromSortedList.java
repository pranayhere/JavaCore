package com.pranay.interview.LinkedList;

import java.util.Stack;

public class RemoveDuplicatesFromSortedList {
    static ListNode head;

    public static void main(String[] args) {
         head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(3);
         head.next.next.next.next = new ListNode(4);
         head.next.next.next.next.next = new ListNode(4);
         head.next.next.next.next.next.next = new ListNode(5);

//        head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);

         ListNode ans = deleteDuplicates(head);

         while (ans != null) {
             System.out.println(ans.val + " -> ");
             ans = ans.next;
         }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && prev.next.val == curr.next.val) {
                curr = curr.next;
            }

            if (prev.next == curr)
                prev = prev.next;
            else
                prev.next = curr.next;

            curr = curr.next;
        }

        return dummy.next;
    }
}