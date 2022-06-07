package com.pranay.interview.dp2.pattern2;

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
        int amount = 11;

        CoinChangeMinCoins cc = new CoinChangeMinCoins();
        int minCoins = cc.coinChangeMinCoins(coins, amount);
        System.out.println("Min Coins : " + minCoins);

        int minCoins2 = cc.coinChangeTabulation(coins, amount);
        System.out.println("Tabulation : " + minCoins2);
    }

    public int coinChangeMinCoins(int[] coins, int amount) {
        return coinChange(coins, amount, coins.length);
    }

    public int coinChange(int[] coins, int amount, int n) {
//        if (n == 0)
//            return Integer.MAX_VALUE;
//
//        if (amount == 0)
//            return 0;

        if (n == 0 || amount <= 0)
            return amount == 0 ? 0 : Integer.MAX_VALUE - 1;

        if (coins[n - 1] <= amount) {
            return Math.min(1 + coinChange(coins, amount - coins[n - 1], n), coinChange(coins, amount, n - 1));
        } else {
            return coinChange(coins, amount, n - 1);
        }
    }

    public int coinChangeTabulation(int[] coins, int total) {
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
