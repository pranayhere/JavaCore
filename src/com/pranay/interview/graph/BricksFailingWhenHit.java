package com.pranay.interview.graph;

import java.util.Arrays;

/**
 * 803. Bricks Falling When Hit
 * https://leetcode.com/problems/bricks-falling-when-hit/
 */
public class BricksFailingWhenHit {
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0,1},
                {1,1,1,0,1}
        };

        int[][] hits = {{1,0}, {0,4}};
        int[] ans = hitBricks(grid, hits);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] hitBricks(int[][] grid, int[][] hits) {
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) grid[hit[0]][hit[1]] = -1;
        }

        for (int j = 0; j < grid[0].length; j++) {
            connect(grid, 0, j);
        }

        print2d(grid);
        System.out.println("-----------");

        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int row = hits[i][0];
            int col = hits[i][1];
            if (grid[row][col] == -1) {
                grid[row][col] = 1;
                if (connectedToTop(grid, row, col)) {
                    res[i] = connect(grid, row, col) - 1;
                }
                print2d(grid);
                System.out.println("H -----------");
            }
        }
        return res;
    }

    private static boolean connectedToTop(int[][] grid, int i, int j) {
        if (i == 0) return true;
        if (i - 1 >= 0 && grid[i - 1][j] == 2) return true;
        if (j - 1 >= 0 && grid[i][j - 1] == 2) return true;
        if (i + 1 < grid.length && grid[i + 1][j] == 2) return true;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 2) return true;
        return false;
    }

    private static int connect(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] != 1)
            return 0;

        grid[r][c] = 2;

        int res = 1;
        res += connect(grid, r + 1, c);
        res += connect(grid, r - 1, c);
        res += connect(grid, r, c + 1);
        res += connect(grid, r, c - 1);

        return res;

    }

    private static void print2d(int[][] arr) {
        for (int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
