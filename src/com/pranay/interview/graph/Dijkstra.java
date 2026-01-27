package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 3650. Minimum Cost Path with Edge Reversals
// https://leetcode.com/problems/minimum-cost-path-with-edge-reversals
public class Dijkstra {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{0, 1, 3}, {3, 1, 1}, {2, 3, 4}, {0, 2, 2}};

        Dijkstra dij = new Dijkstra();
        int cost = dij.minCost(n, edges);

        System.out.println("Min Cost: " +cost);
    }

    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e: edges) {
            int x = e[0];
            int y = e[1];
            int w = e[2];

            g[x].add(new int[]{y, w});
            g[y].add(new int[]{x, 2 * w});
        }

        // dijkstra
        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0}); // [Distance, Node]

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dist = curr[0];
            int x = curr[1];

            if (x == n - 1)
                return dist;

            if (visited[x])
                continue;

            visited[x] = true;

            for (int[] neigh: g[x]) {
                int y = neigh[0];
                int w = neigh[1];

                if (dist + w < d[y]) {
                    d[y] = dist + w;
                    pq.offer(new int[]{d[y], y});
                }
            }
        }

        return -1;
    }
}
