package com.pranay.interview.graph;

public class CheeryPickup2 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
        };

        CheeryPickup2 cp = new CheeryPickup2();
        int total = cp.cherryPickup(grid);
        System.out.println("Total cherries : " + total);
    }

    int[][][] dp;

    private int cherryPickup(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        dp = new int[nr][nc][nc];

        int ans = dfs(grid, 0, 0, nc - 1);
        return ans;
    }

    private int dfs(int[][] grid, int r, int c1, int c2) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r == nr)
            return 0;

        int maxCherries = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int nc1 = c1 + i;
                int nc2 = c2 + j;

                if (nc1 < 0 || nc1 >= nc || nc2 < 0 || nc2 >= nc)
                    continue;

                maxCherries = Math.max(maxCherries, dfs(grid, r + 1, nc1, nc2));
            }
        }

        int currCherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return currCherries + maxCherries;
    }
}
