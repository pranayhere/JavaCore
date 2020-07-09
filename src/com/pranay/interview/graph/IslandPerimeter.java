package com.pranay.interview.graph;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        IslandPerimeter ip = new IslandPerimeter();
        int perimeter = ip.islandPerimeter(grid);
        System.out.println("perimeter : " + perimeter);
    }

    private int islandPerimeter(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        int perimeter = 0;

        boolean[][] visited = new boolean[nr][nc];
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c, visited); // since only one island, so return the result.
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        int nr = grid.length;
        int nc = grid[0].length;

        // boundary cell - return 1
        if (r < 0 || r >= nr || c < 0 || c >= nc)
            return 1;

        // 0 cell, return 1
        if (grid[r][c] == 0)
            return 1;

        // already visited cell, don't consider
        if (visited[r][c])
            return 0;

        visited[r][c] = true;
        int perimeter = 0;

        perimeter += dfs(grid, r + 1, c, visited);
        perimeter += dfs(grid, r - 1, c, visited);
        perimeter += dfs(grid, r, c + 1, visited);
        perimeter += dfs(grid, r, c - 1, visited);

        return perimeter;
    }
}
