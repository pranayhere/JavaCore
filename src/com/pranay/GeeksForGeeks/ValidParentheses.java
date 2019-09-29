package com.pranay.GeeksForGeeks;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "]";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		Stack<String> stk = new Stack<>();
		for (String str: s.split("")) {
			if (str.equals("(") || str.equals("{") || str.equals("[")) {
				stk.push(str);
			} else if (str.equals(")") || str.equals("}") || str.equals("]")) {
				if (stk.size() == 0) {
					return false;
				}
				String tos = stk.peek();
				if (str.equals(")") && tos.equals("(")) {
					stk.pop();
				} else if (str.equals("}") && tos.equals("{")) {
					stk.pop();
				} else if (str.equals("]") && tos.equals("[")) {
					stk.pop();
				} else {
					return false;
				}
			}
		}
		if (stk.isEmpty()) {
			return true;
		}
		return false;
	}
}
