package com.pranay.interview.dp;

/**
 * 1463. Cherry Pickup II
 * https://leetcode.com/problems/cherry-pickup-ii/
 *
 * Idea
 * This is dp solution. At each step, we move both robot1 and robot2 to next row, and with all possibles columns (j-1, j, j+1).
 * Please keep in mind that if 2 robots go the same cell, we only collect cherries once.
 *
 * Complexity
 *
 * Time: O(9 * m * n^2), where m is number of rows, n is number of cols of grid.
 * Space: O(m * n^2)
 */
public class CherryPickup2 {
    public static void main(String[] args) {
        int[][] grid = {
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1}
        };

//        int[][] grid = {{4,10,8,5,7,10,4,1,1},{2,2,5,2,9,2,0,8,10},{7,8,3,1,8,0,1,8,4},{10,5,5,6,3,1,0,4,2},{0,5,6,9,5,9,4,0,3},{9,10,1,7,10,4,0,3,10},{9,10,10,5,6,3,8,9,3},{0,10,3,2,5,6,2,9,1},{6,3,4,0,7,1,5,0,7},{8,4,3,8,10,1,8,10,2}};
        CherryPickup2 cp = new CherryPickup2();
        int cherries = cp.cherryPickup(grid);
        System.out.println("Cherries picked : " + cherries);
    }

    int[][][] dp;
    private int cherryPickup(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        dp = new int[nr][nc][nc];

        int ans = dfs(grid,0, 0, nc - 1);
        return ans;
    }

    private int dfs(int[][] grid, int r, int c1, int c2) { // r=row, c1=robot1 c2=robot2
        int nr = grid.length;
        int nc = grid[0].length;

        if (r == nr)
            return 0;

        if (dp[r][c1][c2] > 0)
            return dp[r][c1][c2];

        int ans = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nc1 = c1 + i; // new column for robot1
                int nc2 = c2 + j; // new column for robot2

                if (nc1 < 0 || nc1 >= nc || nc2 < 0 || nc2 >= nc)
                    continue;

                ans = Math.max(ans, dfs(grid, r + 1, nc1, nc2));
            }
        }
        int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2] = ans + cherries;
    }
}

// 41693583 - iterations without dp
// 366 -  with dp