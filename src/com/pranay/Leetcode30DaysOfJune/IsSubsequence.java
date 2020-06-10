package com.pranay.Leetcode30DaysOfJune;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "", t = "ahbgdc";
        boolean isSubsequence = isSubsequence(s, t);
        System.out.println("Is Subsequence : " + isSubsequence);
    }

    private static boolean isSubsequence(String s, String t) {
        int idx = 0;
        if (s.equals("") || t.equals("")) {
            return false;
        }
        for (int i = 0; i<t.length(); i++) {
            if (s.charAt(idx) == t.charAt(i)) {
                idx++;
            }
            if (idx == s.length()) {
                return true;
            }
        }
        return false;
    }
}
