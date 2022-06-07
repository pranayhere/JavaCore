package com.pranay.interview.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://binarysearch.com/problems/Bus-Fare
 *
 * You are given a list of sorted integers days , where you must take the bus for on each day. Return the lowest cost it takes to travel for all the days.
 *
 * There are 3 types of bus tickets.
 *
 * 1 day pass for 2 dollars
 * 7 day pass for 7 dollars
 * 30 day pass for 25 dollars
 * Constraints
 *
 * n ≤ 100,000 where n is the length of days
 *
 * Input
 * days = [1, 3, 4, 5, 29]
 * Output
 * 9
 * Explanation
 * The lowest cost can be achieved by purchasing a 7 day pass in the beginning and then a 1 day pass on the 29th day.
 */
public class BusFare {
    public static void main(String[] args) {
        int[] days = {1, 3, 4, 5, 29};
        BusFare bf = new BusFare();
        int fare = bf.solve(days);
        System.out.println(fare);
    }

    Map<Integer, Integer> dp;
    public int solve(int[] days) {
        dp = new HashMap<>();
        int cost = Math.min(dfs(days, 0, days[0]) + 2, dfs(days, 0, days[0] + 6) + 7);
        return cost;
    }

    public int dfs(int[] days, int idx, int max) {
        if (idx >= days.length)
            return 0;

        if (dp.getOrDefault(max, 0) > 0)
            return dp.get(max);

        int cost = 0;
        if (days[idx] <= max)
            cost = dfs(days, idx + 1, max);
        else
            cost = Math.min(dfs(days, idx + 1, days[idx] + 6) + 7, dfs(days, idx + 1, days[idx]) + 2);

        dp.put(max, cost);
        return cost;
    }
}
