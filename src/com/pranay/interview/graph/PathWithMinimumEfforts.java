package com.pranay.interview.graph;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 1631. Path With Minimum Effort
 * https://leetcode.com/problems/path-with-minimum-effort/
 * <p>
 * Dijkstra
 */

public class PathWithMinimumEfforts {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int cost = minimumEffortPath(heights);
        System.out.println("Minimum cost : " + cost);
    }

    public static int minimumEffortPath(int[][] heights) {
        int nr = heights.length;
        int nc = heights[0].length;

        int[][] dist = new int[nr][nc];
        for (int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // dist, row, col

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == nr - 1 && c == nc - 1)
                return d;

            if (d > dist[r][c])
                continue;

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR < 0 || newR >= nr || newC < 0 || newC >= nc)
                    continue;

                int newDist = Math.max(d, Math.abs(heights[newR][newC] - heights[r][c]));
                if (newDist < dist[newR][newC]) {
                    dist[newR][newC] = newDist;
                    pq.add(new int[]{newDist, newR, newC});
                }
            }
        }

        return 0;
    }
}
