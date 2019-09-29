package com.pranay;

import java.util.Stack;

public class RemoveAdjacentDuplicates2 {
	public static void main(String[] args) {
		String s = "pbbcggttciiippooaais";
		int k = 2;
		System.out.println(removeDuplicates(s, k));
	}

	public static String removeDuplicates(String S, int k) {
		Stack<String> stk = new Stack<>();
		Stack<Integer> cntStk = new Stack<>();
		for (String s: S.split("")) {
			if (stk.empty()) {
				stk.push(s);
				cntStk.push(1);
				continue;
			}

			String tos = stk.peek();
			if (tos.equals(s) && cntStk.peek() == k - 1) {
				for(int i = 0; i<k-1; i++) {
					stk.pop();
					cntStk.pop();
				}
			} else if (tos.equals(s)) {
				stk.push(s);
				cntStk.push(cntStk.peek() + 1);
			} else {
				stk.push(s);
				cntStk.push(1);
			}
		}

		StringBuilder builder = new StringBuilder();
		while (!stk.empty()) {
			builder.insert(0, stk.pop());
		}
		return builder.toString();
	}
}
