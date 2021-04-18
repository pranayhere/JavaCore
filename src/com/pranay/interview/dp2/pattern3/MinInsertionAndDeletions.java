package com.pranay.interview.dp2.pattern3;

public class MinInsertionAndDeletions {
    public static void main(String[] args) {
        String A = "heap";
        String B = "pea";

        int ans = minInsertionsAndDeletions(A, B);
        System.out.println("Ans : " + ans);
    }

    private static int minInsertionsAndDeletions(String a, String b) {
        int ans = 0;
        int n = a.length();
        int m = b.length();

        dp = new int[n + 1][m + 1];

        int lcs = lcs(a, b, n, m);
        ans += n - lcs;
        ans += m - lcs;
        return ans;
    }

    static int[][] dp;
    private static int lcs(String a, String b, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] > 0)
            return dp[n][m];

        if (a.charAt(n - 1) == b.charAt(m - 1))
            return 1 + lcs(a, b, n - 1, m - 1);
        return Math.max(lcs(a, b, n - 1, m), lcs(a, b, n, m - 1));
    }
}
