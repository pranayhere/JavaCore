package com.pranay.interview.dp;

/**
 * 2291. Maximum Profit From Trading Stocks
 * https://leetcode.com/problems/maximum-profit-from-trading-stocks/
 */
public class MaxProfitFromTreadingStocks {
    public static void main(String[] args) {
        int[] present = {5,4,6,2,3};
        int[] future = {8,5,4,3,5};
        int budget = 10;

        MaxProfitFromTreadingStocks mpts = new MaxProfitFromTreadingStocks();
        int maxProfit = mpts.maximumProfit(present, future, budget);
        System.out.println("Max profit : " + maxProfit);
    }

    int[][] dp;

    public int maximumProfit(int[] present, int[] future, int budget) {
        dp = new int[budget + 1][future.length + 1];
        return dfs(present, future, budget, present.length);
    }

    public int dfs(int[] present, int[] future, int budget, int idx) {
        if (idx == 0)
            return 0;

        if (dp[budget][idx] > 0)
            return dp[budget][idx];

        int profit = 0;

        if (present[idx - 1] > budget) {
            profit = dfs(present, future, budget, idx - 1);
        } else {
            profit = Math.max(dfs(present, future, budget - present[idx - 1], idx - 1) + future[idx - 1] - present[idx - 1], dfs(present, future, budget, idx - 1));
        }

        return dp[budget][idx] = profit;
    }
}
