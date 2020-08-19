package com.pranay.interview.strings;

/**
 * 1544. Make The String Great
 * https://leetcode.com/problems/make-the-string-great/
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "ll";
        String ans = makeGood(s);
        System.out.println("Ans : " + ans);
    }

    private static String makeGood(String s) {
        if (s.length() <= 2 && Math.abs(s.charAt(0) - s.charAt(1)) == 32)
            return "";

        for (int i = 1; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) == 32)
                s = s.substring(0, i-1) + s.substring(i+1);
        }
        return s;
    }
}
