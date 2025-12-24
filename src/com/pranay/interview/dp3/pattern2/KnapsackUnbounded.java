package com.pranay.interview.dp3.pattern2;

import java.util.Arrays;

/**
 * Unbounded Knapsack (Repetition of items allowed)
 *
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti,
 * we need to calculate minimum amount that could make up this quantity exactly.
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 *
 * Input : W = 100
 *        val[]  = {1, 30}
 *        wt[] = {1, 50}
 * Output : 100
 * There are many ways to fill knapsack.
 * 1) 2 instances of 50 unit weight item.
 * 2) 100 instances of 1 unit weight item.
 * 3) 1 instance of 50 unit weight item and 50
 *    instances of 1 unit weight items.
 * We get maximum value with option 2.
 *
 * Input : W = 8
 *        val[] = {10, 40, 50, 70}
 *        wt[]  = {1, 3, 4, 5}
 * Output : 110
 * We get maximum value with one unit of
 * weight 5 and one unit of weight 3.
 */
public class KnapsackUnbounded {
    public static void main(String[] args) {
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{10, 40, 50, 70};
        int W = 8;

        KnapsackUnbounded k = new KnapsackUnbounded();
        int profit = k.knapsack(wt, val, W);
        System.out.println("Max Profit: " + profit);
    }

    int[][] dp;
    public int knapsack(int[] wt, int[] val, int W) {
        dp = new int[W + 1][wt.length + 1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }

        return knapsack(wt, val, W, wt.length);
    }

    public int knapsack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[W][n] >= 0)
            return dp[W][n];

        if (wt[n - 1] <= W) {
            return dp[W][n] = Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),
                    knapsack(wt, val, W, n - 1));
        } else {
            return dp[W][n] = knapsack(wt, val, W, n - 1);
        }
    }
}
