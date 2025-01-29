package com.pranay.interview.stacks;


import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]"; // "3[a]2[bc]";
//        String s = "2[abc]3[cd]ef";
        String output = decodeString2(s);
        System.out.println("Output : " + output);
    }

    private static String decodeString(String s) {
        Stack<Integer> intStk = new Stack<>();
        Stack<String> strStk = new Stack<>();
        String curr = "";

        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStk.push(k);
                strStk.push(curr);
                curr = "";
                k = 0;
            } else if (ch == ']') {
                String tmp = curr;
                curr = strStk.pop();

                for (k = intStk.pop(); k > 0; k--) {
                    curr += tmp;
                }
            } else {
                curr += ch;
            }
        }
        return curr;
    }

    public static String decodeString2(String s) {
        Stack<Integer> intStk = new Stack<>();
        Stack<String> strStk = new Stack<>();

        int num = 0;
        String curr = "";

        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                intStk.push(num);
                strStk.push(curr);
                num = 0;
                curr = "";
            } else if (ch == ']') {
                String tmp = curr;
                curr = strStk.pop();

                for (num = intStk.pop(); num > 0; num--) {
                    curr += tmp;
                }
            } else {
                curr += ch;
            }
        }

        return curr;
    }
}
