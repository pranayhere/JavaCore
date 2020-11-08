package com.pranay.interview.dptuts.knpasack01;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] weight = {24, 18, 18, 10};
        int[] val = {24, 10, 10, 7};
        int W = 25;
        int n = val.length;

        Knapsack01 kpsk = new Knapsack01();
        int ans = kpsk.knapsack(weight, val, W, n);
        int ans2 = kpsk.knapsackMemo(weight, val, W, n);

        System.out.println("Ans : " + ans);
        System.out.println("Ans : " + ans2);
    }

    private int knapsack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (W >= wt[n - 1]) {
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), knapsack(wt, val, W, n - 1));
        } else { // if (W < wt[n - 1]) {
            return knapsack(wt, val, W, n - 1);
        }
    }

    int[][] dp;
    private int knapsackMemo(int[] wt, int[] val, int W, int n) {
        dp = new int[n + 1][W + 1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        if (n == 0 || W == 0)
            return 0;

        System.out.println(Arrays.deepToString(dp));

        if (dp[n][W] != -1)
            return dp[n][W];

        if (W >= wt[n - 1]) {
            return dp[n][W] = Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1), knapsack(wt, val, W, n - 1));
        } else { // if (W < wt[n - 1]) {
            return dp[n][W] = knapsack(wt, val, W, n - 1);
        }
    }
}