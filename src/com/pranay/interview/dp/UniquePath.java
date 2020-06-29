package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */

public class UniquePath {
    public static void main(String[] args) {
        int m = 7, n = 3;
        int noOfPaths = uniquePaths(m, n);
        System.out.println("No Of Paths : " + noOfPaths);
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i<m; i++)
            Arrays.fill(dp[i], 1);

        for (int i = 1; i<m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
