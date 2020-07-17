package com.pranay.interview.dp;

public class MinimumDistanceToTypeWord {
    public static void main(String[] args) {
        String word = "CAKE";
        int dist = minimumDistance(word);
        System.out.println("inimum distance : " + dist);
    }

    private static int minimumDistance(String word) {
        int[] dp = new int[26];
        int res = 0, save = 0, n = word.length();

        for (int i = 0; i < n - 1; i++) {
            int b = word.charAt(i) - 'A';
            int c = word.charAt(i + 1) - 'A';

            for (int a = 0; a < 26; ++a)
                dp[b] = Math.max(dp[b], dp[a] + d(b, c) - d(a, c));

            save = Math.max(save, dp[b]);
            res += d(b, c);
        }
        return res - save;
    }

    private static int d(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}
