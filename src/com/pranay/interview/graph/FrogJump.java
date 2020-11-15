package com.pranay.interview.graph;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        boolean ans = canCross(stones);
        System.out.println("Ans : " + ans);
    }

    private static boolean canCross(int[] stones) {
        if (stones.length == 0 || stones.length == 1)
            return false;

        if (stones[1] - stones[0] != 1)
            return false;

        Map<Integer, Boolean>[] memo = new HashMap[stones.length];

        for (int i = 0; i < stones.length; i ++) {
            memo[i] = new HashMap<Integer, Boolean>();
        }

        return dfs(stones, 0, 1, memo);
    }

    private static boolean dfs(int[] stones, int idx, int k, Map<Integer, Boolean>[] memo) {
        if (idx == stones.length - 1)
            return true;

        Map<Integer, Boolean> map = memo[idx];
        if (map.containsKey(k)) return map.get(k);

        for (int i = idx + 1; i < stones.length; i++) {
            int distance = stones[i] - stones[idx];

            if (distance > k + 1) break;
            if (distance < k - 1) continue;

            if (dfs(stones, i, distance, memo)) {
                map.put(k, true);
                return true;
            }
        }

        map.put(k, false);
        return false;
    }
}
