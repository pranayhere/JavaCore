package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BestMeetingPoint {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        int minPointDistance = minTotalDistance(grid);
        System.out.println("Min Point Distance : " + minPointDistance);
    }

    public static int minTotalDistance(int[][] grid) {
        int minDist = Integer.MAX_VALUE;

        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                int dist = bfs(grid, r, c);
                minDist = Math.min(dist, minDist);
            }
        }
        return minDist;
    }

    public static int bfs(int[][] grid, int row, int col) {
        Queue<Point> q = new ArrayDeque<>();
        int nr = grid.length;
        int nc = grid[0].length;
        int totalDist = 0;

        q.add(new Point(row, col, 0));
        boolean[][] visited = new boolean[nr][nc];

        while (!q.isEmpty()) {
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            int d = p.d;

            if (r < 0 || r >= nr || c < 0|| c >= nc || visited[r][c])
                continue;

            if (grid[r][c] == 1)
                totalDist += d;

            visited[r][c] = true;
            q.add(new Point(r + 1, c, d +1));
            q.add(new Point(r - 1, c, d +1));
            q.add(new Point(r, c + 1, d +1));
            q.add(new Point(r, c - 1, d +1));
        }

        return totalDist;
    }

    static class Point {
        int r;
        int c;
        int d; // distance

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
