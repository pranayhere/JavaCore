package com.pranay.interview.dpTusharRoy.pattern2;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */

public class CoinChangeMinCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amt = 11;

        int minCoins = coinChangeMinCoins(coins, amt);
        System.out.println("Min coins : " + minCoins);
    }

    private static int coinChangeMinCoins(int[] coins, int total) {
        int[][] dp = new int[coins.length + 1][total + 1];
        for (int i = 1; i <= total; i++)
            dp[0][i] = total + 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }

        for (int[] arr: dp)
            System.out.println(Arrays.toString(arr));

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
