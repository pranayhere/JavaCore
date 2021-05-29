package com.pranay.interview.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class BasicCalculator3 {
    public static void main(String[] args) {
        String s = "2*(5+5*2)/3+(6/2+8)";
        int ans = calculate(s);
        System.out.println("Ans : " + ans);
    }

    private static int calculate(String s) {
        System.out.println((int)Math.ceil((double) -8/31*-1));

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.addLast(i);
            if (s.charAt(i) == ')')
                hm.put(stack.removeLast(), i);
        }
        return calc(s, 0, s.length(), hm);
    }

    public static int calc(String s, int start, int end, Map<Integer, Integer> hm) {

        char sign = '+';
        int val = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = start; i < end; i++) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                val = val * 10 + (s.charAt(i) - '0');
            }
            if (s.charAt(i) == '(') {
                val = calc(s, i + 1, hm.get(i), hm);
                i = hm.get(i);
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || i == end - 1) {
                if (sign == '+') {
                    stack.addLast(val);
                } else if (sign == '-') {
                    stack.addLast(val * -1);
                } else if (sign == '*') {
                    stack.addLast(val * stack.removeLast());
                } else if (sign == '/') {
                    stack.addLast(stack.removeLast() / val);
                }
                sign = s.charAt(i);
                val = 0;
            }
        }

        val = 0;

        while (!stack.isEmpty()) {
            val += stack.removeLast();
        }
        return val;
    }
}
