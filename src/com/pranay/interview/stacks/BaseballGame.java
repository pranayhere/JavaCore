package com.pranay.interview.stacks;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int points = calPoints(ops);
        System.out.println("Final score : " + points);
    }

    private static int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];

            if (op.matches("-?\\d+")) {
                stk.push(Integer.parseInt(op));
            } else if (op.equals("C")) {
                stk.pop();
            } else if (op.equals("D")) {
                if (!stk.isEmpty()) {
                    Integer points = stk.peek();
                    stk.push(points * 2);
                }
            } else if (op.equals("+")) {
                if (stk.size() >= 2) {
                    Integer fir = stk.pop();
                    Integer sec = stk.pop();

                    stk.push(sec);
                    stk.push(fir);
                    stk.push(fir + sec);
                }
            }
        }
        int ans = 0;
        while (!stk.isEmpty()) {
            ans += stk.pop();
        }
        return ans;
    }
}
