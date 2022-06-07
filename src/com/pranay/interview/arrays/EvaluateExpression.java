package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class EvaluateExpression {
    public static void main(String[] args) {
//        String str = "100+(2+12)/14"; // ans = 101
//        String str = "100+200+300";
//        String str = "100+200/100";
        String str = "100+(14+14)*2";

        EvaluateExpression s = new EvaluateExpression();
        int res = s.evaluate(str);

        System.out.println(res);
    }

    public int evaluate(String str) {
        str += "+";
        Stack<Integer> braces = new Stack<>();
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                braces.push(i);
            }

            if (str.charAt(i) == ')') {
                hm.put(braces.pop(), i);
            }
        }

        System.out.println(str + "::::" + hm);

        int num = 0;
        char op = '+';
        int res = 0;

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                num = evaluate(str.substring(i + 1, hm.get(i)));
                i = hm.get(i);
                ch = str.charAt(i);
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                if (op == '+') {
                    stk.push(num);
                } else if (op == '-') {
                    stk.push(-num);
                } else if (op == '*') {
                    stk.push(stk.pop() * num);
                } else if (op == '/') {
                    stk.push(stk.pop() / num);
                }

                num = 0;
                op = ch;
            }
        }

        System.out.println("Stack :" + stk);

        while (!stk.isEmpty()) {
            res += stk.pop();
        }

        return res;
    }
}