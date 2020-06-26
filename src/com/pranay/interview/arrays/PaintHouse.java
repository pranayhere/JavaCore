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

    private int[][] costs;
    private Map<String, Integer> memo;

    private int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        this.memo = new HashMap<>();
        int min = Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
        System.out.println(memo);
        return min;
    }

    private int paintCost(int n, int color) {
        if (memo.containsKey(getKey(n, color))) {
            return memo.get(getKey(n, color));
        }
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) {
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) {
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else {
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        memo.put(getKey(n, color), totalCost);
        return totalCost;
    }

    private String getKey(int n, int color) {
        return String.valueOf(n) + "-" + String.valueOf(color);
    }
}
