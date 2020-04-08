package com.pranay.Leetcode30days;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}

public class MiddleOfTheLinkedList {
	static ListNode head;
	public static void main(String[] args) {
		MiddleOfTheLinkedList list = new MiddleOfTheLinkedList();
		list.head = new ListNode(1);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);
		list.head.next.next.next.next.next = new ListNode(6);

		ListNode middle = findMiddle(head);
		System.out.println("Middle : " + middle.val);
	}

	private static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast.next == null) {
			return slow;
		}
		return slow.next;
	}
}
