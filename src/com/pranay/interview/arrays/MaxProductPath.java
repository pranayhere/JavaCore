package com.pranay.interview.arrays;

/**
 * 1594. Maximum Non Negative Product in a Matrix
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
 */

public class MaxProductPath {
    public static void main(String[] args) {
        int[][] grid = {
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };
        MaxProductPath mpp = new MaxProductPath();
        int ans = mpp.maxProductPath(grid);
        System.out.println("Ans : " + ans);
    }

    long maxProd = -1;

    public int maxProductPath(int[][] grid) {
        int mod = (int)1e9 + 7;
        dfs(grid, 0, 0, 1);
        return (int) (maxProd % mod);
    }

    private void dfs(int[][] grid, int r, int c, long curr) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc)
            return;

        if (grid[r][c] == 0) {
            maxProd = Math.max(0, maxProd);
            return;
        }


        if (r == nr - 1 && c == nc - 1) {
            long prod = (curr * grid[r][c]);
            maxProd = Math.max(prod, maxProd);
            return;
        }


        curr = (curr * grid[r][c]);
        dfs(grid, r + 1, c, curr);
        dfs(grid, r, c + 1, curr);
    }
}
