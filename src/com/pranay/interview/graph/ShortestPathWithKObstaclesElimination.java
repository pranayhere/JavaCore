package com.pranay.interview.graph;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */

public class ShortestPathWithKObstaclesElimination {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };
        int k = 1;

        int steps = shortestPath(grid, k);
        System.out.println("Steps : " + steps);
    }

    // dfs without dp
    private static int shortestPath(int[][] grid, int k) {
        int nr = grid.length;
        int nc = grid[0].length;

        boolean[][] seen = new boolean[nr][nc];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        int steps = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                if (cur[0] == nr - 1 && cur[1] == nc - 1)
                    return steps;

                for (int[] dir: dirs) {
                    int r = dir[0] + cur[0];
                    int c = dir[1] + cur[1];

                    if (r < 0 || r >= nr || c < 0 || c >= nc)
                        continue;

                    int obstacles = grid[r][c] + cur[2];
                    if (obstacles > k)
                        continue;

                    seen[r][c] = true;
                    q.offer(new int[]{r, c, obstacles});
                }
            }
            steps++;
        }
        return -1;
    }

    // dfs with DP, seen is used to store the number of obstacles;
    private static int shortestPath2(int[][] grid, int k) {
        int nr = grid.length;
        int nc = grid[0].length;

        int[][] seen = new int[nr][nc];
        for (int i = 0; i < nr; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        int steps = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                if (cur[0] == nr - 1 && cur[1] == nc - 1)
                    return steps;

                for (int[] dir: dirs) {
                    int r = dir[0] + cur[0];
                    int c = dir[1] + cur[1];

                    if (r < 0 || r >= nr || c < 0 || c >= nc)
                        continue;

                    int obstacles = grid[r][c] + cur[2];
                    if (obstacles >= seen[r][c] || obstacles > k)
                        continue;

                    seen[r][c] = obstacles;
                    q.offer(new int[]{r, c, obstacles});
                }
            }
            steps++;
        }
        return -1;
    }
}
