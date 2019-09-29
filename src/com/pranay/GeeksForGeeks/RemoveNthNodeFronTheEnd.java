package com.pranay.GeeksForGeeks;

public class RemoveNthNodeFronTheEnd {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		l3.next = l4;
		ListNode l5 = new ListNode(5);
		l4.next = l5;
		l5.next = null;

		ListNode head = removeNthFromEnd(l1, 2);
		System.out.println(head.val);
		while (head.next != null) {
			head = head.next;
			System.out.println(head.val);
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;

		for (int i = 0; i<n; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummy.next;
	}
}
