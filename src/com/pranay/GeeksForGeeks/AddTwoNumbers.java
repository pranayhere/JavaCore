package com.pranay.GeeksForGeeks;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		l3.next = null;
		
		ListNode a1 = new ListNode(5);
		ListNode a2 = new ListNode(6);
		a1.next = a2;
		ListNode a3 = new ListNode(4);
		a2.next = a3;
		a3.next = null;
		
		ListNode list = addTwoNumbers(l1, a1);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		int[] num1 = getNumber(l1, new int[], 0);
//		long num2 = getNumber(l2, 1);
//		String num = num1+num2 + "";
//		StringBuilder input1 = new StringBuilder(); 
//		  
        // append a string into StringBuilder input1 
//        input1.append(num); 
//  
//        // reverse StringBuilder input1 
//        input1 = input1.reverse();
//        num = input1.toString();
//		return buildNodeList(num);
		return null;
	}

	
	public static ListNode buildNodeList(String num) {
//		System.out.println("num : " +num);
		String[] arr = num.split("");
		ListNode[] list = new ListNode[arr.length];
		ListNode node = new ListNode(Integer.parseInt(arr[0]));
//		System.out.println(node.val);
		ListNode pre = node;
		for (int i = 1; i<arr.length; i++) {
			ListNode newNode = new ListNode(Integer.parseInt(arr[i]));
//			System.out.println(newNode.val);
			pre.next = newNode;
			pre = pre.next; 
		}
//		System.out.println("Printing pre : ");
//		long num1 = getNumber(node, 1);
//		System.out.println(num1);
		return node;
	}

	public static int[] getNumber(ListNode l1, int[] arr, int i) {
		if (l1 == null) {
			return arr;
		}
//		System.out.println(l1.val);
		arr[i] = l1.val;
		return getNumber(l1.next, arr, i+1);
	}

}
