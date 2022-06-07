package com.pranay.interview.dp2.pattern3;

import java.util.Arrays;

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    static int[][] memo;
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int len = lcs.longestCommonSubsequence(text1, text2);

        memo = new int[text1.length() + 1][text2.length() + 1];
        int lcnMemo = lcs.longestCommonSubsequenceMemo(text1, text2, text1.length(), text2.length());
        int lcsTab = lcs.longestCommonSubsequenceTab(text1, text2);

        System.out.println("len Rec : "  + len);
        System.out.println("Memo : "  + lcnMemo);
        System.out.println("Tab : "  + lcsTab);
    }

    public int longestCommonSubsequence(String s1, String s2) {
        return longestCommonSubsequenceRec(s1, s2, s1.length(), s2.length());
    }

    private int longestCommonSubsequenceRec(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + longestCommonSubsequenceRec(s1, s2, m - 1, n - 1);
        else
            return Math.max(longestCommonSubsequenceRec(s1, s2, m - 1, n), longestCommonSubsequenceRec(s1, s2, m, n - 1));
    }

    private int longestCommonSubsequenceMemo(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (memo[m][n] > 0)
            return memo[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return memo[m][n] = 1 + longestCommonSubsequenceMemo(s1, s2, m - 1, n - 1);
        else
            return memo[m][n] = Math.max(longestCommonSubsequenceMemo(s1, s2, m - 1, n), longestCommonSubsequenceMemo(s1, s2, m, n - 1));
    }

    public int longestCommonSubsequenceTab(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
