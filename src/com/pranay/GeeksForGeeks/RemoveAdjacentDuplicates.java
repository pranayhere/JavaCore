package com.pranay.GeeksForGeeks;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
	public static void main(String[] args) {
		String S = "abbaca";
		System.out.println(removeDuplicates(S));
	}

	public static String removeDuplicates(String S) {
		Stack<String> stk = new Stack<>();
		StringBuilder ans = new StringBuilder();

		for (String s: S.split("")) {
			if (stk.isEmpty()) {
				stk.push(s);
				continue;
			}
			String tos = stk.peek();
			if (tos.equals(s)) {
				stk.pop();
			} else {
				stk.push(s);
			}
		}

		while(!stk.isEmpty()) {
			ans.append(stk.pop());
		}
		ans.reverse();
		return ans.toString();
	}
}
