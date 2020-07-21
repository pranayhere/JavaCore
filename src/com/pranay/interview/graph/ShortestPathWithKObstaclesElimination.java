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
                {1,1,1},
                {0,0,1},
                {0,1,1},
                {0,1,0}
        };
        int k = 2;

        int steps = shortestPath(grid, k);
        System.out.println("Steps : " + steps);
    }

    private static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] seen = new int[m][n]; // min obstacles elimination from (0,0) to (x, y)
        for (int i = 0; i < m; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        seen[0][0] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
//                System.out.println("curr : " + Arrays.toString(cur));
//                for (int[] see: seen) {
//                    System.out.println(Arrays.toString(see));
//                }
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return steps;
                }

                for (int[] dir: dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if (x < 0 || x >= m || y < 0 || y >= n)
                        continue;

                    int obstacles = grid[x][y] + cur[2];
                    if (obstacles >= seen[x][y] || obstacles > k)
                        continue;

                    seen[x][y] = obstacles;
                    q.offer(new int[] {x, y, obstacles});
                }
            }
            System.out.println("-----------------");
            steps++;
        }

        System.out.println("Returning here ::");
        return -1;
    }
}
