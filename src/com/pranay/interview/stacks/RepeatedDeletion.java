package com.pranay.interview.stacks;

// https://binarysearch.com/problems/Repeated-Deletion

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class RepeatedDeletion {
    public static void main(String[] args) {
        String s = "abbbaac";
        String ans = removeDuplicates(s);
        System.out.println("Ans : " + ans);
    }

    public static String removeDuplicates(String s) {
        Stack<Map.Entry<Character, Integer>> stk = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek().getKey() == ch) {
                Map.Entry<Character, Integer> curr = stk.pop();
                stk.push(new AbstractMap.SimpleEntry<>(ch, curr.getValue() + 1));
            } else if (!stk.isEmpty() && stk.peek().getKey() != ch) {
                if (stk.peek().getValue() > 1) {
                    stk.pop();
                }

                if (!stk.isEmpty() && stk.peek().getKey() == ch) {
                    Map.Entry<Character, Integer> curr = stk.pop();
                    stk.push(new AbstractMap.SimpleEntry<>(ch, curr.getValue() + 1));
                } else {
                    stk.push(new AbstractMap.SimpleEntry<>(ch, 1));
                }
            } else {
                stk.push(new AbstractMap.SimpleEntry<>(ch, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            Map.Entry<Character, Integer> poped = stk.pop();
            if (poped.getValue() > 1)
                continue;

            sb.append(poped.getKey());
        }
        return sb.reverse().toString();
    }
}
