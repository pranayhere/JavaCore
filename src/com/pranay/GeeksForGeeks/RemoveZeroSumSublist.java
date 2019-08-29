package com.pranay.GeeksForGeeks;
// 1171. Remove Zero Sum Consecutive Nodes from Linked List
// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSublist {
    public static void main(String[] args) {
        int[] val = {1,2,-3,3,1};
        ListNode listNode = new ListNode(val[0]);
        ListNode head = listNode;
        for (int i = 1; i<val.length; i++) {
            listNode.next = new ListNode(val[i]);
            listNode = listNode.next;
        }
        listNode.next=null;

        ListNode list = removeZeroSumSublists(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    private static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null)
            return head;

        Map<Integer, ListNode> hm = new HashMap<>();
        int sum = 0;
        ListNode curr = head;
        while (curr != null) {
            sum += curr.val;
            if (sum == 0) {
                head = curr.next;
            }  else if (hm.containsKey(sum)) {
                ListNode node = hm.get(sum);
                node.next = curr.next;
            } else {
                hm.put(sum, curr);
            }
            curr = curr.next;
        }
        return head;
    }
}
