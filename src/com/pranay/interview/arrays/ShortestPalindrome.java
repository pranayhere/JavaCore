package com.pranay.interview.arrays;

public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "abcbabcab";
        String ans = shortestPalindrome(s);
        System.out.println("Ans : " + ans);
    }

    private static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;

        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();

        System.out.println(t);
        for (int i = 0; i < t.length(); i++) {
            if (s.startsWith(t.substring(i))) {
                return t.substring(0, i) + s;
            }
        }
        return t + s;
    }
}
