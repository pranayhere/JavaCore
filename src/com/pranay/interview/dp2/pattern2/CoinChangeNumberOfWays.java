package com.pranay.interview.dp2.pattern2;

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
        int[] coins = {1, 2, 3};
        int total = 5;

        CoinChangeNumberOfWays cc = new CoinChangeNumberOfWays();
        int ways = cc.noOfWays(coins, total);
        System.out.println("Ways : " + ways);

        int ways2 = cc.noOfWaysTab(coins, total);
        System.out.println("tabulation : " + ways2);
    }

    int[][] memo;
    private int noOfWays(int[] coins, int total) {
        memo = new int[coins.length + 1][total + 1];
        return noOfWays(coins, total, coins.length);
    }

    private int noOfWays(int[] coins, int total, int n) {
        if (total == 0)
            return 1;

        if (n == 0)
            return 0;

        if (memo[n][total] > 0)
            return memo[n][total];

        if (coins[n - 1] <= total)
            return memo[n][total] = noOfWays(coins, total - coins[n - 1], n) + noOfWays(coins, total, n - 1);
        else
            return memo[n][total] = noOfWays(coins, total, n - 1);
    }

    private int noOfWaysTab(int[] coins, int total) {
        int[][] dp = new int[coins.length + 1][total + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}