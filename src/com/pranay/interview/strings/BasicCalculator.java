package com.pranay.interview.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";

        BasicCalculator bs = new BasicCalculator();
        int ans = bs.calculate(s);

        System.out.println("Ans: " + ans);
    }

    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> hm = new HashMap<>(); // start bracket, end bracket

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stk.push(i);

            if (s.charAt(i) == ')')
                hm.put(stk.pop(), i);
        }

        return calc(s, 0, s.length(), hm);
    }

    public int calc(String s, int start, int end, Map<Integer, Integer> hm) {
        char sign = '+';
        int val = 0;

        Stack<Integer> stk = new Stack<>();
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                val = val * 10 + (ch - '0');
            }

            if (ch == '(') {
                val = calc(s, i + 1, hm.get(i), hm);
                i = hm.get(i);
            }

            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (sign == '+') {
                    stk.push(val);
                } else if (sign == '-') {
                    stk.push(-1 * val);
                } else if (sign == '*') {
                    stk.push(val * stk.pop());
                } else if (sign == '/') {
                    stk.push(stk.pop() / val);
                }

                sign = s.charAt(i);
                val = 0;
            }
        }

        val = 0;

        while (!stk.isEmpty()) {
            val += stk.pop();
        }

        return val;
    }
}
