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

        int lcs = lcsRec(a, b, n, m);
        int lcsMemo = lcsMemo(a, b, n, m);
        int lcsTab = lcsTab(a, b, n, m);

        System.out.println("LCS : " + lcs);
        System.out.println("LCS Memo : " + lcsMemo);
        System.out.println("LCS Tab : " + lcsTab);

        ans += n - lcs;
        ans += m - lcs;
        return ans;
    }

    public static int lcsRec(String a, String b, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (a.charAt(n - 1) == b.charAt(m - 1))
            return 1 + lcsRec(a, b, n - 1, m - 1);
        else
            return Math.max(lcsRec(a, b, n - 1, m), lcsRec(a, b, n, m - 1));
    }

    static int[][] dp;
    private static int lcsMemo(String a, String b, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] > 0)
            return dp[n][m];

        if (a.charAt(n - 1) == b.charAt(m - 1))
            return 1 + lcsMemo(a, b, n - 1, m - 1);
        else
            return Math.max(lcsMemo(a, b, n - 1, m), lcsMemo(a, b, n, m - 1));
    }

    public static int lcsTab(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}
