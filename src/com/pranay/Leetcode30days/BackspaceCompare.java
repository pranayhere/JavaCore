package com.pranay.Leetcode30days;


import java.util.Stack;

public class BackspaceCompare {
	public static void main(String[] args) {
		String S = "y#fo##f";
		String T = "y#f#o##f";
		boolean isSame = backspaceCompare(S, T);
		System.out.println("Is same : " + isSame);
	}

	private static boolean backspaceCompare(String s, String t) {
		String s1 = finalString(s);
		String s2 = finalString(t);
		return s1.equals(s2);
	}

	private static String finalString(String str) {
		Stack<String> stk = new Stack<>();
		String[] arr = str.split("");
		for (String s : arr) {
			if (s.equals("#")) {
				if (!stk.isEmpty()) {
					stk.pop();
				}
			} else {
				stk.push(s);
			}
		}

		StringBuffer sb = new StringBuffer();
		while (!stk.isEmpty())
			sb.append(stk.pop());
		return sb.toString();
	}
}
