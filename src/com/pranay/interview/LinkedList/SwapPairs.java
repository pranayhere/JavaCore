package com.pranay.interview.LinkedList;

public class SwapPairs {
    static ListNode head;
    public static void main(String[] args) {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode ans = swapPairs(head);
        while (ans != null) {
            System.out.println(ans.val + " ->");
            ans = ans.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode prevprev = null;
        ListNode zero = new ListNode();
        ListNode prevprevprev = zero;
        zero.next = head;
        ListNode curr = head;

        while (curr != null) {
            if (prev == null) {
                prev = curr;
                curr = curr.next;
            } else if (prevprev == null) {
                prevprev = prev;
                prev = curr;
                curr = curr.next;
            } else if (prev != null && prevprev != null) {
                prev.next = prevprev;
                prevprev.next = curr;
                prevprevprev.next = prev;

                prevprevprev = prevprev;
                prev = null;
                prevprev = null;

            }
        }

        return zero.next;
    }
}
