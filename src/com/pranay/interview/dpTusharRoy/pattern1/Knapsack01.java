package com.pranay.interview.dpTusharRoy.pattern1;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] val = {1, 4, 5, 7};
        int[] wt = {1, 3, 4, 5};
        int W = 7;

        int maxProfit = knapsack01(val, wt, W);
        System.out.println("Max profit : " + maxProfit);
    }

    private static int knapsack01(int[] val, int[] wt, int W) {
        int[][] dp = new int[wt.length + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
