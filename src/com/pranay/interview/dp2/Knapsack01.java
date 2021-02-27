package com.pranay.interview.dp2;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {2, 4, 5, 7};
        int W = 10;

        int maxProfit = knapsack01Rec(wt, val, W);
        System.out.println("Max Profit Rec : " + maxProfit);

        int maxProfitMemo = knapsack01Memo(wt, val, W);
        System.out.println("Max Profit Memo : " + maxProfitMemo);

        int maxProfitTD = knapsack01TopDown(wt, val, W);
        System.out.println("Max profit : " + maxProfitTD);
    }

    // --------------------------------- Recursive --------------------------
    private static int knapsack01Rec(int[] wt, int[] val, int W) {
        return knapsack(wt, val, W, wt.length);
    }

    private static int knapsack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] <= W)
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), knapsack(wt, val, W, n - 1));
        else
            return knapsack(wt, val, W, n - 1);
    }

    // ---------------------------------- Memo Recursive ----------------------
    static int[][] dp;
    public static int knapsack01Memo(int[] wt, int[] val, int W) {
        dp = new int[W + 1][wt.length + 1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        return knapsackMemo(wt, val, W, wt.length);
    }

    private static int knapsackMemo(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0)
            return 0;

        if (dp[w][n] >= 0)
            return dp[w][n];

        int profit = 0;
        if (wt[n - 1] <= w)
            profit =  Math.max(val[n - 1] + knapsackMemo(wt, val, w - wt[n - 1], n - 1), knapsackMemo(wt, val, w, n - 1));
        else
            profit = knapsackMemo(wt, val, w, n - 1);

        return dp[w][n] = profit;
    }

    // ---------------------------------- top down dp --------------------------
    private static int knapsack01TopDown(int[] wt, int[] val, int W) {
        int[][] dp = new int[wt.length + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < wt[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
