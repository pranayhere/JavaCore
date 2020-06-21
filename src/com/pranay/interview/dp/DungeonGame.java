package com.pranay.interview.dp;

import java.util.Arrays;

public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        int minCost = calculateMinimumHP(dungeon);
        System.out.println("Min Cost : " + minCost);
    }

    private static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 1 && dungeon[0].length == 1) {
            return 1;
        }

        int[][] dp = new int[dungeon.length][dungeon[0].length];

        dp[0][0] = dungeon[0][0];
        for (int i = 1; i<dp[0].length; i++) {
            dp[0][i] = dp[0][i-1] + dungeon[0][i];
        }

        for (int i = 1; i<dp.length; i++) {
            dp[i][0] = dp[i-1][0] + dungeon[i][0];
        }

        for (int i = 1; i<dungeon.length; i++) {
            for (int j = 1; j<dungeon[0].length; j++) {
                int min = Math.min(Math.abs(dp[i-1][j]), Math.abs(dp[i][j-1]));
                if (min == Math.abs(dp[i-1][j])) {
                    min = dp[i-1][j];
                } else {
                    min = dp[i][j-1];
                }
                dp[i][j] = min+ dungeon[i][j];
            }
        }

        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[dp.length - 1][dp[0].length - 1] <= 0 ? 1 + Math.abs(dp[dp.length - 1][dp[0].length - 1]) : dp[dp.length - 1][dp[0].length - 1];
    }
}
