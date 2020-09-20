package com.pranay.interview.graphAll.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 317. Shortest Distance from All Buildings
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 */
public class ShortestDistanceFromAllBuildings {
    public static void main(String[] args) {
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        int dist = shortestDistance(grid);
        System.out.println("Shortest Distance : " + dist);
    }

    static class Point {
        int r, c, d;

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    private static int shortestDistance(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int minDist = Integer.MAX_VALUE;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] != 2) {
                    int dist = bfs(grid, r, c);
                    minDist = Math.min(minDist, dist);
                }
            }
        }
        return minDist;
    }

    private static int bfs(int[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(row, col, 0));

        boolean[][] seen = new boolean[nr][nc];
        int totDist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point curr = q.poll();
                int r = curr.r;
                int c = curr.c;
                int d = curr.d;

                if (r < 0 || r >= nr || c < 0 || c >= nc || seen[r][c] || grid[r][c] == 2)
                    continue;

                if (grid[r][c] == 1)
                   totDist += curr.d;

                seen[r][c] = true;
                q.offer(new Point(r + 1, c, d + 1));
                q.offer(new Point(r - 1, c, d + 1));
                q.offer(new Point(r, c + 1, d + 1));
                q.offer(new Point(r, c - 1, d + 1));
            }
        }

        return totDist;
    }
}
