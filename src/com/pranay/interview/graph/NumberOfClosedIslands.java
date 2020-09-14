package com.pranay.interview.graph;

/**
 * 1254. Number of Closed Islands
 * https://leetcode.com/problems/number-of-closed-islands/
 */
public class NumberOfClosedIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        int count = closedIsland(grid);
        System.out.println("Closed Islands : " + count);
    }

    private static int closedIsland(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        for (int c = 0; c < nc; c++) {
            if (grid[0][c] == 0)
                dfs(0, c, grid);

            if (grid[nr - 1][c] == 0)
                dfs(nr - 1, c, grid);
        }

        for (int r = 0; r < nr; r++) {
            if (grid[r][0] == 0)
                dfs(r, 0, grid);

            if (grid[r][nc - 1] == 0)
                dfs(r, nc - 1, grid);
        }

        int islands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 0) {
                    islands++;
                    dfs(r, c, grid);
                }
            }
        }

        return islands;
    }

    public static void dfs(int r, int c, int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] != 0)
            return;

        grid[r][c] = 2;
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }
}
