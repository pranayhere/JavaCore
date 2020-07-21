package com.pranay.interview.graph;

import java.util.ArrayList;
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
        int left = 0, right = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else if (s.charAt(i) == ')' && left > 0)
                left--;
            else if (s.charAt(i) == ')')
                right++;
        }

        // Find how many min. no. of changes are required
        count = left + right;
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), count);
        return new ArrayList<>(res);
    }

    private static void dfs(String s, int i, Set<String> res, StringBuilder sb, int count) {
        if (count < 0)
            return;

        if (i == s.length()) {
            if (count == 0) {
                if (isValid(sb.toString())) {
                    res.add(sb.toString());
                }
            }
            return;
        }

        char c = s.charAt(i);
        int len = sb.length();

        if (c == '(' || c == ')') {
            dfs(s, i + 1, res, sb, count - 1); // don't add parentheses
            dfs(s, i + 1, res, sb.append(c), count); // add parentheses
        } else {
            dfs(s, i + 1, res, sb.append(c), count); // any other letter
        }

        sb.setLength(len);
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                count++;
            if (ch == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }
}
