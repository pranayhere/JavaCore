package com.pranay.interview.dp2.pattern3;

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int len = lcs.longestCommonSubsequence(text1, text2);
        System.out.println("Longest common subsequence : "  + len);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] memo = new int[m][n];
        return lcs(text1, text2, text1.length(), text2.length(), memo);
    }

    public int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;

        if (memo[m - 1][n - 1] > 0)
            return memo[m - 1][n - 1];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return memo[m - 1][n - 1] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else
            return memo[m - 1][n - 1] = Math.max(lcs(s1, s2, m - 1, n, memo), lcs(s1, s2, m, n - 1, memo));
    }
}
