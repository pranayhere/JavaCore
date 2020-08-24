package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String S = "(a)())()";
        List<String> list = removeInvalidParentheses(S);
        System.out.println(list);
    }

    private static List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(')
                left++;
            else if (ch == ')' && left > 0)
                left--;
            else if (ch == ')')
                right++;
        }

        int count = left + right;
        Set<String> res = new HashSet<>();

        dfs(s, 0, res, new StringBuilder(), count);
        return new ArrayList<>(res);
    }

    private static void dfs(String s, int i, Set<String> res, StringBuilder sb, int count) {
        if (count < 0)
            return;

        if (i == s.length()) {
            if (count == 0) {
                if (isValid(sb.toString()))
                    res.add(sb.toString());
            }
            return;
        }

        char ch = s.charAt(i);
        int len = sb.length();

        if (ch == '(' || ch == ')') {
            dfs(s, i + 1, res, sb, count - 1); // removed parenthesis
            dfs(s, i + 1, res, sb.append(ch), count); // don't remove parenthesis
        } else {
            dfs(s, i + 1, res, sb.append(ch), count); // any other char
        }

        sb.setLength(len);
    }

    private static boolean isValid(String s) {
        int count = 0;

        for (char ch: s.toCharArray()) {
            if (ch == '(')
                count++;
            else if (ch == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }
}