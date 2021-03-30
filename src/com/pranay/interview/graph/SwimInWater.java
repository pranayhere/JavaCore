package com.pranay.interview.graph;

import java.util.PriorityQueue;

/**
 * 778. Swim in Rising Water
 * https://leetcode.com/problems/swim-in-rising-water/
 *
 * Idea is similar to Dijkstra's algorithm. Each iteration, we will select the neighbouring cell which is having least water level.
 * Once we selected it, we will push all of its neighbours,that have not visited to the priority queue.
 *
 * Complexity will be O(N2 log N)
 */
public class SwimInWater {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };

        int time = swimInWater(grid);
        System.out.println("Time : " + time);
    }

    private static int swimInWater(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int max = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        pq.offer(new int[]{0, 0});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] seen = new boolean[nr][nc];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            max = Math.max(max, grid[curr[0]][curr[1]]);

            if (curr[0] == nr - 1 && curr[1] == nc - 1)
                return max;

            for (int[] d: dirs) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];

                if (x < 0 || x >= nr || y < 0 || y >= nc || seen[x][y])
                    continue;

                seen[curr[0]][curr[1]] = true;
                pq.offer(new int[]{x, y});
            }
        }

        return max;
    }
}
