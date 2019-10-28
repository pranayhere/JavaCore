package com.pranay.GeeksForGeeks;

import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String[] args) {
		String str = "";
		int size = longestValidParentheses(str);
		System.out.println(size);
	}

	private static int longestValidParentheses(String str) {
		int max = 0;
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);
		String[] arr = str.split("");

		for (int i = 0; i<arr.length; i++) {
			if (arr[i].equals("(")) {
				stk.push(i);
			} else {
				stk.pop();
				if (stk.isEmpty()) {
					stk.push(i);
				} else {
					max = Math.max(max, i - stk.peek());
				}
			}
		}
		return max;
	}
}
