package com.pranay.interview.arrays;


import java.util.Stack;

/**
 * 1653. Minimum Deletions to Make String Balanced
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 */
public class MinimumDeletions {
    public static void main(String[] args) {
        String s = "aababbab";
        int ans = minimumDeletions(s);
        System.out.println("Ans : " + ans);
    }

    public static int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int min = 0;

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() > c) {
                st.pop();
                min++;
            } else {
                st.push(c);
            }
        }

        return min;
    }
}
