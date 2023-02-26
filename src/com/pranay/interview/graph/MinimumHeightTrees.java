package com.pranay.interview.graph;

import java.util.*;

/**
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/
 */

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            List<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                centroids.add(i);
            }

            return centroids;
        }

        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] e: edges) {
            g.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (g.containsKey(i) && g.get(i).size() == 1)
                leaves.add(i);

        int remaining = n;
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (Integer leaf: leaves) {
                Integer neigh = g.get(leaf).iterator().next();
                g.get(neigh).remove(leaf);

                if (g.get(neigh).size() == 1)
                    newLeaves.add(neigh);
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
