package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxNetworkRank {
    public static void main(String[] args) {
//        int n = 4;
//        int[][] roads = {{0,1},{0,3},{1,2},{1,3}};
        int n = 6;
        int[][] roads = {{2,4}};
        int ans = maximalNetworkRank(n, roads);
        System.out.println("Ans : " + ans);
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> conn = new HashMap<>();

        for (int[] road: roads) {
            conn.computeIfAbsent(road[0], k-> new HashSet<>()).add(road[1]);
            conn.computeIfAbsent(road[1], k-> new HashSet<>()).add(road[0]);
        }

        System.out.println(conn);

        Set<Integer> list = conn.keySet();

        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> roadI = conn.get(i);
                Set<Integer> roadJ = conn.get(j);

                if (roadI == null || roadJ == null)
                    continue;

                if (roadI.contains(j) && roadJ.contains(i))
                    maxSize = Math.max(maxSize, roadI.size() + roadJ.size() - 1);
                else
                    maxSize = Math.max(maxSize, roadI.size() + roadJ.size());
            }
        }
        return maxSize;
    }
}
