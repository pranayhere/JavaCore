package com.pranay.interview.dp;

/**
 * Double String Concatenation
 * https://binarysearch.com/problems/Double-String-Concatenation
 */
public class DoubleStringConcat {
    public static void main(String[] args) {
        String s = "abczbdc";
        int edits = doubleConcat(s);
        System.out.println("Minimum Edits : " + edits);
    }

    public static int doubleConcat(String s) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i <= s.length(); i++) {
            String w1 = s.substring(0, i);
            String w2 = s.substring(i);
            int dist = editDistance(w1, w2);
            System.out.println(w1 + " --- " + w2 + " ---- " + dist);
            minDistance = Math.min(dist, minDistance);
        }

        return minDistance;
    }

    public static int editDistance(String w1, String w2) {
        int[][] dp = new int[w1.length() + 1][w2.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
