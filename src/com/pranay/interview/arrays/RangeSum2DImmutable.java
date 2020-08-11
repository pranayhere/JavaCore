package com.pranay.interview.arrays;

import java.util.Arrays;

public class RangeSum2DImmutable {
    int[][] dp;

    public RangeSum2DImmutable(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;

        dp = new int[nr][nc + 1];

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                dp[r][c + 1] = matrix[r][c] + dp[r][c];
            }
        }

        for (int[] a: dp) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        RangeSum2DImmutable rs2d = new RangeSum2DImmutable(matrix);
        System.out.println(rs2d.sumRegion(2, 1, 4, 3));
        System.out.println(rs2d.sumRegion(1, 1, 2, 2));
        System.out.println(rs2d.sumRegion(1, 2, 2, 4));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            ans += dp[i][col2 + 1] - dp[i][col1];
        }
        return ans;
    }
}
