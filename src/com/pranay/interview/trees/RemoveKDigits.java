package com.pranay.interview.trees;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "112";
        int k = 1;
        String smallestNumber = removeKdigits(num, k);
        System.out.println("Smallest Number : " + smallestNumber);
    }

    private static String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();

        if (k >= num.length()) {
            return "0";
        }

        for (char digit : num.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.peek() > digit) {
                stk.pop();
                k--;
            }
            stk.add(digit);
            System.out.println(stk);
        }

        for(int i=0; i<k; ++i) {
            stk.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.insert(0, stk.pop());
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String ans = sb.replace(0, i, "").toString();
        return ans.equals("") ? "0" : ans ;
    }
}
