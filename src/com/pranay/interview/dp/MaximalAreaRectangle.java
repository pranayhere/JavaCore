package com.pranay.interview.dp;

import java.util.Arrays;

public class MaximalAreaRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int area = maxRectalgle(matrix);
        System.out.println("Area : " + area);
    }

    private static int maxRectalgle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                    int width = dp[i][j];

                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }
            }
        }
        print2d(dp);
        return maxArea;
    }

    private static void print2d(int[][] dp) {
        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
