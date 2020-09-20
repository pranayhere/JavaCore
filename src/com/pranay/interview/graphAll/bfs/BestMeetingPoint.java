package com.pranay.interview.graphAll.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 296. Best Meeting Point
 * https://leetcode.com/problems/best-meeting-point/
 */

public class BestMeetingPoint {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};

        int distance = minTotalDistance(grid);
        int dist = minTotalDistanceOptimised(grid);

        System.out.println(distance);
        System.out.println(dist);
    }

    static class Point {
        int r, c, dist;
        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.dist = d;
        }
    }

    private static int minTotalDistance(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int minDist = Integer.MAX_VALUE;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                int dist = findDist(grid, r, c);
                minDist = Math.min(dist, minDist);
            }
        }
        return minDist;
    }

    private static int findDist(int[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(row, col, 0));

        boolean[][] visited = new boolean[nr][nc];

        int totalDistance = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point curr = q.poll();
                int r = curr.r;
                int c = curr.c;
                int d = curr.dist;

                if (r < 0 || r >= nr || c < 0 || c >= nc || visited[r][c])
                    continue;

                if (grid[r][c] == 1)
                    totalDistance += curr.dist;

                visited[r][c] = true;

                q.offer(new Point(r + 1, c, d + 1));
                q.offer(new Point(r - 1, c, d + 1));
                q.offer(new Point(r, c + 1, d + 1));
                q.offer(new Point(r, c - 1, d + 1));
            }
        }
        return totalDistance;
    }

    // optimized : Sorting and median, read solution section in above question to understand why median works well

    public static int minTotalDistanceOptimised(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);

        return minDist(rows, row) + minDist(cols, col);
    }

    public static int minDist(List<Integer> points, int origin) {
        int dist = 0;
        for (int p: points) {
            dist += Math.abs(p - origin);
        }

        return dist;
    }
}
