package com.pranay.Leetcode31DaysOfMay;

import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class OddEvenList {
    static ListNode node = null;
    public static void main(String[] args) {
        OddEvenList list = new OddEvenList();
        list.node = new ListNode(1);
        list.node.next = new ListNode(2);
        list.node.next.next = new ListNode(3);

        ListNode oddEven = oddEvenList(node);
        while (oddEven != null && oddEven.next != null) {
            System.out.print(oddEven.val + " ->");
            oddEven = oddEven.next;
        }
        System.out.println(oddEven.val + " ->NULL");
        String str = "ans ans1 ans2";
        String[] ans = str.split(" ", 2);
        System.out.println(Arrays.toString(ans));

    }

    private static ListNode oddEvenList(ListNode node) {
        if (node == null) {
            return null;
        }

        ListNode odd = node;
        ListNode even = node.next;
        ListNode ans = new ListNode(node.val);
        ListNode res = ans;

        if (even == null) {
            return odd;
        }

        while (odd.next != null && odd.next.next != null) {
            odd = odd.next.next;
            res.next = new ListNode(odd.val);
            res = res.next;
        }

        res.next = new ListNode(even.val);
        res = res.next;
        while (even.next != null && even.next.next != null) {
            even = even.next.next;
            res.next = new ListNode(even.val);
            res = res.next;
        }
        return ans;
    }
}
