package com.pranay.interview.graph;

/**
 * 1568. Minimum Number of Days to Disconnect Island
 * https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
 * <p>
 * intuition:
 * There can be maximum 2 days to disconnect the island
 * ex:
 * 1 1 1      1 1 1
 * 1 1 1  ->  1 1 *
 * 1 1 1      1 * 1
 * <p>
 * so, number of days will always be <= 2
 * now, we want to check can we disconnect island in 0 or 1 day
 * <p>
 * Island can be disconnected in 0 days, if there is no island or there are more than 1 island. i.e. there is nothing to disconnect if there is no island. or if
 * there are two islands that means they are already disconnected.
 *
 * if there is only one island, we have seen above, in max two days, we can disconnect it. Now we need to check if we can disconnect the island in just 1 day.
 * To check, if we can disconnect the island in one day, we iterate over the grid and set grid[r][c] = 0, and count the islands,
 * if island count is > 1, that means we can disconnect island in just one day.
 * else ans is 2.
 */
public class NumberOfDaysToDisconnectIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int days = minDays(grid);
        System.out.println("Days : " + days);
    }

    private static int minDays(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (noOfIsland(grid) != 1) { // we already have two or zero islands, i.e. already disconnected
            return 0;
        }

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    grid[r][c] = 0;
                    if (noOfIsland(grid) > 1) { // we can disconnect island in one day.
                        return 1;
                    }
                    grid[r][c] = 1;
                }
            }
        }

        return 2; // two days are required to disconnect the island
    }

    private static int noOfIsland(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        boolean[][] seen = new boolean[nr][nc];
        int islands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1 && !seen[r][c]) {
                    islands++;
                    dfs(grid, seen, r, c);
                }
            }
        }
        return islands;
    }

    private static void dfs(int[][] grid, boolean[][] seen, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == 0 || seen[r][c])
            return;

        seen[r][c] = true;
        dfs(grid, seen, r + 1, c);
        dfs(grid, seen, r - 1, c);
        dfs(grid, seen, r, c + 1);
        dfs(grid, seen, r, c - 1);
    }
}
