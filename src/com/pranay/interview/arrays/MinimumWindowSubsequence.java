package com.pranay.interview.arrays;

/**
 * 727. Minimum Window Subsequence
 * https://leetcode.com/problems/minimum-window-subsequence/solution/
 *
 * we can conduct two steps by using two pointers for this probelm:
 * 1. check feasibility from left to right
 * 2. check optimization from right to left
 * we can traverse from left to right, find a possible candidate until reach the first ending character of T
 * eg: for the string s = abcdebdde and t = bde, we should traverse s string until we find first e,
 * i.e. abcde, then traverse back from current "e" to find if we have other combination of bde with smaller
 * length.
 * @param right: fast pointer that always points the last character of T in S
 * @param left: slow pointer that used to traverse back when right pointer find the last character of T in S
 * @param tIndex: third pointer used to scan string T
 * @param minLen: current minimum length of subsequence
 * */

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String S = "abcdebdde", T = "bde";
        String minSubsequence = minWindow(S, T);
        System.out.println("Min Subsequence : " + minSubsequence);
    }

    private static String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0)
            return "";

        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";

        while (right < S.length()) {
            int tIdx = 0;

            while (right < S.length()) {
                if (S.charAt(right) == T.charAt(tIdx))
                    tIdx++;

                if (tIdx == T.length())
                    break;

                right++;
            }

            if (right == S.length())
                break;

            int left = right;
            tIdx = T.length() - 1;

            while (left >= 0) {
                if (S.charAt(left) == T.charAt(tIdx))
                    tIdx--;

                if (tIdx < 0)
                    break;

                left--;
            }

            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                res = S.substring(left, right + 1);
            }

            right = left + 1;
        }


        return res;
    }
}
