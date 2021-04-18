package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1135. Connecting Cities With Minimum Cost
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 *
 * prims algorithm minimum spanning tree
 */
public class PrimsConnectCitiesWithMinCost {
    public static void main(String[] args) {
        int N = 3;
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};

        PrimsConnectCitiesWithMinCost ccc = new PrimsConnectCitiesWithMinCost();
        int cost = ccc.minimumCost(N, connections);
        System.out.println("Minimum cost : " + cost);
    }

    public int minimumCost(int N, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn: connections) {
            int x = conn[0], y = conn[1], cost = conn[2];

            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{y, cost});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{x, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{1, 1, 0});

        Set<Integer> visited = new HashSet<>();
        int costs = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

            if (visited.contains(y))
                continue;

            visited.add(y);
            costs += cost;

            for (int[] next: graph.get(y)) {
                pq.add(new int[]{y, next[0], next[1]});
            }
        }

        return visited.size() == N ? costs : -1;
    }
}
