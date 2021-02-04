package com.pranay.interview.graph;

import java.util.Stack;

public class MaxScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;

        int gain = maximumGain(s, x, y);
        System.out.println("Gain : " + gain);
    }

    private static int maximumGain(String s, int x, int y) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();

        int res = 0;
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        char first = (x > y) ? 'a' : 'b', second = (x > y) ? 'b' : 'a';
        for (char ch : s.toCharArray()) {
            if (!stk1.isEmpty() && stk1.peek() == first && ch == second) {
                stk1.pop();
                res += max;
            } else {
                stk1.push(ch);
            }
        }

        while (!stk1.isEmpty()) {
            char ch = stk1.pop();
            if (!stk2.isEmpty() && stk2.peek() == first && ch == second) {
                stk2.pop();
                res += min;
            } else {
                stk2.push(ch);
            }
        }

        return res;
    }
}