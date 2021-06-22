package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class PaintHouse {
    public static void main(String[] args) {
        PaintHouse ph = new PaintHouse();
        int[][] costs = {
                {5,8,6},
                {19,14,13},
                {7,5,12},
                {14,15,17},
                {3,20,10}
        };
        int cost = ph.minCost(costs);
        System.out.println("Min cost : " + cost);
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] memo = new int[n + 1][costs[0].length];
        return Math.min(dfs(costs, n, 0, memo), Math.min(dfs(costs, n, 1, memo), dfs(costs, n, 2, memo)));
    }

    public int dfs(int[][] costs, int n, int idx, int[][] memo) {
        if (n == 0)
            return 0;

        if (memo[n][idx] > 0)
            return memo[n][idx];

        int c = 0;
        if (idx == 0) {
            c += costs[n - 1][idx] + Math.min(dfs(costs, n - 1, 1, memo), dfs(costs, n - 1, 2, memo));
        } else if (idx == 1) {
            c += costs[n - 1][idx] + Math.min(dfs(costs, n - 1, 0, memo), dfs(costs, n - 1, 2, memo));
        } else {
            c += costs[n - 1][idx] + Math.min(dfs(costs, n - 1, 0, memo), dfs(costs, n - 1, 1, memo));
        }

        return memo[n][idx] = c;
    }
}
