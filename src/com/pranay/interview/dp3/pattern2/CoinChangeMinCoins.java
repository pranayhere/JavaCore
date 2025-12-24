package com.pranay.interview.dp3.pattern2;

public class CoinChangeMinCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChangeMinCoins c = new CoinChangeMinCoins();
        int minCoins = c.minCoins(coins, amount, coins.length);
        System.out.println("Min Coins: " + minCoins);
    }

    private int minCoins(int[] coins, int amount, int n) {
        if (n == 0 || amount <= 0)
            return amount == 0 ? 0 : Integer.MAX_VALUE - 1;

        if (coins[n - 1] <= amount) {
            return Math.min(1 + minCoins(coins, amount - coins[n - 1], n), minCoins(coins, amount, n - 1));
        } else {
            return minCoins(coins, amount, n - 1);
        }

    }
}

