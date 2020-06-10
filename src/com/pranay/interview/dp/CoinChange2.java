package com.pranay.interview.dp;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        int ways = change(amount, coins);
        System.out.println("No of ways : " + ways);
    }

    private static int change(int total, int[] coins) {
        int dp[][] = new int[coins.length + 1][total + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        print2d(dp);
        return dp[coins.length][total];
    }

    private static void print2d(int[][] dp) {
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
