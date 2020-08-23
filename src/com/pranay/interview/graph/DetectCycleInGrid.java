package com.pranay.interview.graph;

/**
 * 1559. Detect Cycles in 2D Grid
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 */
public class DetectCycleInGrid {
    public static void main(String[] args) {
        char[][] grid = {
                {'a', 'a', 'a', 'a'},
                {'d', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };

        DetectCycleInGrid detectCycle = new DetectCycleInGrid();
        boolean ans = detectCycle.containsCycle(grid);
        System.out.println("Ans : " + ans);
    }

    int[][] depthArr;

    public boolean containsCycle(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        depthArr = new int[nr][nc];

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (dfs(grid, grid[r][c], r, c, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, char ch, int r, int c, int depth) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc)
            return false;

        if (grid[r][c] == Character.toUpperCase(ch)) {
            if (depth - depthArr[r][c] >= 4)
                return true;
            return false;
        }

        if (grid[r][c] != ch)
            return false;

        grid[r][c] = Character.toUpperCase(ch);
        depthArr[r][c] = depth;

        return dfs(grid, ch, r + 1, c, depth + 1)
                || dfs(grid, ch, r - 1, c, depth + 1)
                || dfs(grid, ch, r, c + 1, depth + 1)
                || dfs(grid, ch, r, c - 1, depth + 1);
    }
}
