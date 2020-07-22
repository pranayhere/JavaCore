package com.pranay.interview.graph;

import java.util.HashMap;

/**
 * Stone Game 2
 * https://leetcode.com/problems/stone-game-ii/
 */

public class StoneGame2 {
    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        int canAlexWin = stoneGame2(piles);
        System.out.println("Alex Win Score: " + canAlexWin);
    }

    int[] ps;
    private static int stoneGame2(int[] piles) {
        int[] ps = new int[piles.length];
        ps[0] = piles[0];
        for (int i = 1; i < piles.length; i++) {
            ps[i] = ps[i - 1] + piles[i];
        }
        HashMap<String, Integer> cache = new HashMap<>();
        return dfs(1, 0, piles, cache);
    }

    private static int dfs(int M, int i, int[] piles, HashMap<String, Integer> cache) {
        if (i == piles.length)
            return 0;

        if (cache.containsKey(M + " " + i))
            return cache.get(M + " " + i);

        int max = -1; // max value current player can get
        int preSum = i - 1 < 0 ? 0 : piles[i - 1];

        for (int k = 0; k <= 2 * M - 1; k++) {
            if (k + i == piles.length)
                break;

            int next = dfs(Math.max(k + 1, M), i + k + 1, piles, cache);
            int count = next + piles[k + i] - preSum;

            max = Math.max(max, count);
        }

        int nextVal = piles[piles.length - 1] - preSum - max;
        cache.put(M + " " + i, nextVal);
        if (i == 0)
            return max;
        return nextVal;
    }
}
