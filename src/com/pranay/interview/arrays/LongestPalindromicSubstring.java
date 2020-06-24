package com.pranay.interview.arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String ans = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring : " + ans);
    }

    private static String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i<s.length(); i++) {
            int lenEven = expendFromCenter(s, i, i);
            int lenOdd = expendFromCenter(s, i, i + 1);

            int len = Math.max(lenEven, lenOdd);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expendFromCenter(String s, int L, int R) {
        while (L >= 0 && R <s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
