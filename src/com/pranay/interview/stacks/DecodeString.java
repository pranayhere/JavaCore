package com.pranay.interview.stacks;


import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String output = decodeString(s);
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
}
