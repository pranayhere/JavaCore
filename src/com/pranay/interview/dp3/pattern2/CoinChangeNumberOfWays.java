package com.pranay.interview.dp3.pattern2;

/**
 * Given coins and total, find how many different ways you can pick the coins to get the given total.
 * Ex : coins = {1, 2, 3}
 * total = 5
 *
 * ways :
 * 1 1 1 1 1
 * 1 1 1 2
 * 1 2 2
 * 1 1 3
 * 2 3
 *
 * Ans : 5
 */
public class CoinChangeNumberOfWays {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,3};
        int total = 5;

        CoinChangeNumberOfWays c = new CoinChangeNumberOfWays();
        int ways = c.coinChange(coins, total, coins.length);
        System.out.println("ways: " + ways);
    }

    public int coinChange(int[] coins, int total, int n) {
        if (total == 0)
            return 1;

        if (n == 0)
            return 0;

        if (coins[n - 1] <= total)
            return coinChange(coins, total - coins[n - 1], n) + coinChange(coins, total, n - 1);
        else
            return coinChange(coins, total, n - 1);
    }
}
