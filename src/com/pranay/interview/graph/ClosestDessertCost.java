package com.pranay.interview.graph;

public class ClosestDessertCost {
    public static void main(String[] args) {
        int[] baseCost = {1, 7};
        int[] toppings = {3, 4};
        int target = 10;

        ClosestDessertCost cdc = new ClosestDessertCost();
        int cost = cdc.closestCost(baseCost, toppings, target);
        System.out.println("Closest cost : " + cost);
    }

    int result = 0;
    int min = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int base : baseCosts)
            dfs(toppingCosts, 0, base, target);
        return result;
    }

    private void dfs(int[] toppings, int i, int cost, int target) {
        if (i == toppings.length) {
            if (Math.abs(target - cost) < min) {
                result = cost;
                min = Math.abs(target - cost);
            }
            return;
        }

        dfs(toppings, i + 1, cost, target);
        dfs(toppings, i + 1, cost + toppings[i], target);
        dfs(toppings, i + 1, cost + toppings[i] * 2, target);
    }
}