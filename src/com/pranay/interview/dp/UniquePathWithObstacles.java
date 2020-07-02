package com.pranay.interview.dp;

import java.util.Arrays;

public class UniquePathWithObstacles {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        };

        int paths = uniquePaths(grid);
        System.out.println("Paths : " + paths);
    }

    private static int uniquePaths(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = 1;
        for (int i = 1; i < dp[0].length; i++) {
            if (grid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            if (grid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i <dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - 1];
                }
            }
        }

        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
