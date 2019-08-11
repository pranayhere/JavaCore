package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.Objects;

// Coin change number of ways to get the sum using infinite supply of the coins with given denominator

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int minCoins = coinChange(coins, amount);
        System.out.println("Minimum coins : " +minCoins);
    }

    private static int coinChange(int[] coins, int total) {

        int[][] temp = new int[coins.length+1][total + 1];

        for (int i = 0; i <= coins.length; i++) {
            temp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (coins[i - 1] > j) {
                    temp[i][j] = temp[i - 1][j];
                } else {
                    temp[i][j] = temp[i][j - coins[i - 1]] + temp[i - 1][j];
                }
            }
        }

        return temp[coins.length][total];
    }
}
