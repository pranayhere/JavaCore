package com.pranay.interview.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        String ans = minRemoveToMakeValid(s);
        System.out.println("Ans : " + ans);
    }

    private static String minRemoveToMakeValid(String s) {
        Set<Integer> idxToDelete = new HashSet<>();
        Deque<Integer> stk = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            }

            if (s.charAt(i) == ')') {
                if (stk.isEmpty()) {
                    idxToDelete.add(i);
                } else {
                    stk.pop();
                }
            }
        }

        while (!stk.isEmpty()) {
            idxToDelete.add(stk.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!idxToDelete.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
