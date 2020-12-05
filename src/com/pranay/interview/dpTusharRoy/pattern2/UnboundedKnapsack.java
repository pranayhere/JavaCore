package com.pranay.interview.dpTusharRoy.pattern2;

import java.util.Arrays;

/**
 * Unbounded Knapsack (Repetition of items allowed)
 *
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti,
 * we need to calculate minimum amount that could make up this quantity exactly.
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 *
 * Input : W = 8
 *        val[] = {10, 40, 50, 70}
 *        wt[]  = {1, 3, 4, 5}
 * Output : 110
 * We get maximum value with one unit of
 * weight 5 and one unit of weight 3.
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        int W = 8;

        int profit = maxProfit(val, wt, W);
        System.out.println("Max Profit : " + profit);
    }

    private static int maxProfit(int[] val, int[] wt, int W) {
        int[][] dp = new int[wt.length + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < wt[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wt[i - 1]] + val[i - 1]);
            }
        }

        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
