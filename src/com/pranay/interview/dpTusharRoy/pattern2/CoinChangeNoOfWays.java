package com.pranay.interview.dpTusharRoy.pattern2;

import java.util.Arrays;

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
public class CoinChangeNoOfWays {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int total = 5;

        int ans = noOfWays(coins, total);
        System.out.println("No of ways : " + ans);
    }

    private static int noOfWays(int[] coins, int total) {
        int[][] dp = new int[coins.length][total + 1];

        Arrays.fill(dp[0], 1);
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
            }
        }

        for (int[] arr: dp)
            System.out.println(Arrays.toString(arr));

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
