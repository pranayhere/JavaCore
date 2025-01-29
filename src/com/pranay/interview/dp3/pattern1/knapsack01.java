package com.pranay.interview.dp3.pattern1;

import com.pranay.interview.dp2.pattern1.Knapsack01;

import java.util.Arrays;

/*
Given N items where each item has some weight and profit associated with it
and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it].
The task is to put the items into the bag such that the sum of profits associated with
them is the maximum possible.

Note: The constraint here is we can either put an item completely into the bag or cannot
put it at all [It is not possible to put a part of an item into the bag].

Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select
the item with weight 4, the possible profit is 1. And if we select the item with
weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we
cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0
 */
public class knapsack01 {
    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int[] profit = new int[]{1, 2, 3};
        int[] weight = new int[]{4, 5, 1};

        knapsack01 k = new knapsack01();
        int maxProfit = k.knapsack01(weight, profit, W, N);
        System.out.println("Max Profit = " + maxProfit);

        int maxProfitDp = k.knapsack01Memo(weight, profit, W, N);
        System.out.println("Max Profit = " + maxProfitDp);
    }

    public int knapsack01(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack01(wt, val, W - wt[n - 1], n - 1),
                    knapsack01(wt, val, W, n - 1));
        } else {
            return knapsack01(wt, val, W, n - 1);
        }
    }

    int[][] dp;
    public int knapsack01Memo(int[] wt, int[] val, int W, int n) {
        dp = new int[W + 1][n + 1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }

        return knapsackMemo(wt, val, W, n);
    }

    public int knapsackMemo(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[W][n] >= 0) {
            return dp[W][n];
        }

        int profit = 0;
        if (wt[n - 1] <= W) {
            profit = Math.max(val[n - 1] + knapsackMemo(wt, val, W - wt[n - 1], n - 1),
                    knapsackMemo(wt, val, W, n - 1));
        } else {
            profit = knapsackMemo(wt, val, W, n - 1);
        }

        return dp[W][n] = profit;
    }
}
