package com.pranay.interview.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 983. Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinimumCostForTicket {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        MinimumCostForTicket mct = new MinimumCostForTicket();
        int cost = mct.mincostTickets(days, costs);
        System.out.println(cost);
    }

    Integer[] memo = new Integer[366];
    int[] costs;
    Set<Integer> dayset = new HashSet<>();

    public int mincostTickets(int[] days, int[] c) {
        for (int d: days)
            dayset.add(d);

        costs = c;
        return dfs(1);
    }

    public int dfs(int day) {
        if (day > 365)
            return 0;

        if (memo[day] != null)
            return memo[day];

        int ans = 0;
        if (dayset.contains(day)) {
            ans = Math.min(dfs(day + 1) + costs[0], dfs(day + 7) + costs[1]);
            ans = Math.min(ans, dfs(day + 30) + costs[2]);
        } else {
            ans = dfs(day + 1);
        }

        memo[day] = ans;
        return ans;
    }
}
