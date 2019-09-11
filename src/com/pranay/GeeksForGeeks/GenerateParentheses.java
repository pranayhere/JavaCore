package com.pranay.GeeksForGeeks;

// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }

    public static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList();
        ArrayList<String> result = new ArrayList<>();
        generateParenthesis(0, 0, n, "", result);
        return result;
    }

    private static void generateParenthesis(int open, int close, int max, String prefix, ArrayList<String> result) {
        if (open == max && close == max) {
            result.add(prefix);
        }

        if (open < max) {
            generateParenthesis(open + 1, close, max, prefix + "(", result);
        }

        if (close < open) {
            generateParenthesis(open, close + 1, max, prefix + ")", result);
        }
    }
}
