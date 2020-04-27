package com.pranay.GeeksForGeeks;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '0', '0', '1', '0'}
        };

        int len = maximalSquare(matrix);
        System.out.println("Len : " + len);
    }

    private static int maximalSquare(char[][] m) {
        if (m.length == 0 || m[0].length == 0)
            return 0;

        int[][] dp = new int[m.length + 1][m[0].length + 1];

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j<dp[0].length; j++) {
                if (m[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
