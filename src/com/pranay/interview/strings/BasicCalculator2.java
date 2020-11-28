package com.pranay.interview.strings;

import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args) {
        String s = "3+2*2";
        int ans = calculate(s);
        System.out.println("Ans : " + ans);
    }

    private static int calculate(String s) {
        char sign = '+';
        int val = 0;
        Stack<Integer> stack = new Stack<>();

        s = (s.replaceAll(" ", "") + '+');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                val = val * 10 + (s.charAt(i) - '0');
                continue;
            }

            if (sign == '+') {
                stack.push(val);
            } else if (sign == '-') {
                stack.push(val * -1);
            } else if (sign == '*') {
                stack.push(val * stack.pop());
            } else if (sign == '/') {
                stack.push(stack.pop() / val);
            }
            sign = ch;
            val = 0;
        }

        val = 0;

        while (!stack.isEmpty()) {
            val += stack.pop();
        }
        return val;
    }
}
