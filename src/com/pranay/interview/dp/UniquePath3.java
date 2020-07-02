package com.pranay.interview.dp;

public class UniquePath3 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        int count = uniquePathsIII(grid);
        System.out.println("Ans : " + count);
    }

    private static int uniquePathsIII(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r<nr; r++) {
            for (int c = 0; c < nr; c++) {
                // dfs
            }
        }
        return 0;
    }
}
