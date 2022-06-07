package com.pranay.interview.dp2.pattern3;

public class LongestCommonSubstring {
    static int[][] memo;
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "zbcdgh";

        LongestCommonSubstring ls = new LongestCommonSubstring();
        int ans = ls.longestCommonSubstring(s1, s2);
        int ans2 = ls.longestCommonSubstringRec(s1, s2, s1.length(), s2.length(), 0);

        memo = new int[s1.length() + 1][s2.length() + 1];
        int ans3 = ls.longestCommonSubstringMemo(s1, s2, s1.length(), s2.length(), 0);

        System.out.println("Ans : " + ans);
        System.out.println("Rec : " + ans2);
        System.out.println("Memo : " + ans3);
    }

    private int longestCommonSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0;

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }


    public int longestCommonSubstringRec(String s1, String s2, int m, int n, int count) {
        if (m == 0 || n == 0)
            return count;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return longestCommonSubstringRec(s1, s2, m - 1, n - 1, count + 1);
        else
            return Math.max(count, Math.max(longestCommonSubstringRec(s1, s2, m - 1, n, 0), longestCommonSubstringRec(s1, s2, m, n - 1, 0)));
    }


    public int longestCommonSubstringMemo(String s1, String s2, int m, int n, int count) {
        if (m == 0 || n == 0)
            return count;

        if (memo[m][n] > 0)
            return memo[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return memo[m][n] = longestCommonSubstringRec(s1, s2, m - 1, n - 1, count + 1);
        else
            return memo[m][n] = Math.max(count, Math.max(longestCommonSubstringRec(s1, s2, m - 1, n, 0), longestCommonSubstringRec(s1, s2, m, n - 1, 0)));
    }
}
