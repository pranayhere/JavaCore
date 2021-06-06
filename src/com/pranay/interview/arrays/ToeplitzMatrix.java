package com.pranay.interview.arrays;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2},
                {3, 0, 1},
                {4, 3, 0},
                {5, 4, 3}
        };

        boolean ans = checkToeplitz(grid);
        System.out.println("Ans : " + ans);
    }

    private static boolean checkToeplitz(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            if (!checkDiagonal(grid, r, 0))
                return false;
        }

        for (int c = 0; c < nc; c++) {
            if (!checkDiagonal(grid, 0, c))
                return false;
        }

        return true;
    }

    public static boolean checkDiagonal(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        int res = grid[r][c];
        while (++r < nr && ++c < nc) {
            if (grid[r][c] != res)
                return false;
        }

        return true;
    }
}
