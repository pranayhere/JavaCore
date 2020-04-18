package com.pranay.Leetcode30days;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {
	public static void main(String[] args) {
//		String s = "(*))";
		String s = ")(";
//		String s = ")";
//		String s = "(*()";
//		String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
		boolean ans = checkValidString(s);
		System.out.println("Is Valid : " + ans);
	}

	private static boolean checkValidString(String str) {
		Stack<String> symbol = new Stack<>();
		Stack<Integer> pos = new Stack<>();
		List<Integer> stars = new ArrayList<>();

		String[] s = str.split("");
		for (int i = 0; i<s.length; i++) {
			System.out.println(s[i]);
			if (s[i].equals("(")) {
				symbol.push("(");
				pos.push(i);
			} else if (s[i].equals("*")) {
				stars.add(i);
			}  else if (s[i].equals(")")) {
				if (!symbol.isEmpty() && symbol.peek().equals("(")) {
					symbol.pop();
					pos.pop();
				} else if (!stars.isEmpty() && stars.get(stars.size() - 1) < i) {
					stars.remove(stars.size() - 1);
				} else {
					return false;
				}
			}
			System.out.println(symbol);
			System.out.println(pos);
			System.out.println(stars);
			System.out.println();
		}
		while (!symbol.isEmpty() && !stars.isEmpty()) {
			if (symbol.peek().equals("(") && stars.get(stars.size() - 1) > pos.peek()) {
				symbol.pop();
				pos.pop();
				stars.remove(stars.size() - 1);
			} else {
				return false;
			}
		}
		return symbol.isEmpty();
	}
}
