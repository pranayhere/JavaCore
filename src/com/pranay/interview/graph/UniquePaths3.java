package com.pranay.interview.graph;

/**
 * 980. Unique Paths III
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class UniquePaths3 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };

        UniquePaths3 up = new UniquePaths3();
        int paths = up.uniquePathsIII(grid);
        System.out.println("Unique Paths : " + paths);
    }

    int res = 0;
    int empty = 1;
    int sr, sc; // start row/col

    private int uniquePathsIII(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 0)
                    empty++;
                else if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                }
            }
        }

        dfs(grid, sr, sc);
        return res;
    }

    public void dfs(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] < 0)
            return;

        if (grid[r][c] == 2) {
            if (empty == 0)
                res++;
            return;
        }

        grid[r][c] = -2;
        empty--;

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

        empty++;
        grid[r][c] = 0;
    }
}
