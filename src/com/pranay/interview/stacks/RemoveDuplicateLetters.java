package com.pranay.interview.stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "abbbaac";
        String ans = removeDuplicateLetters(s);
        System.out.println("Ans : " + ans);
    }

    private static String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> lastOccr = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccr.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!seen.contains(ch)) {
                while (!stk.isEmpty() && ch < stk.peek() && lastOccr.get(stk.peek()) > i) {
                    seen.remove(stk.pop());
                }

                seen.add(ch);
                stk.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch: stk)
            sb.append(ch);

        return sb.toString();
    }
}
