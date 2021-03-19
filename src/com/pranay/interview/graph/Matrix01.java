package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 */

public class Matrix01 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ans = updateMatrix(grid);
        System.out.println("Dist : " + Arrays.deepToString(ans));
    }

    public static int[][] updateMatrix(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                } else {
                    grid[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d: dirs) {
                int newR = r + d[0];
                int newC = c + d[1];

                if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || grid[newR][newC] <= grid[r][c] + 1)
                    continue;

                q.offer(new int[] {newR, newC});
                grid[newR][newC] = grid[r][c] + 1;
            }
        }
        return grid;
    }
}
