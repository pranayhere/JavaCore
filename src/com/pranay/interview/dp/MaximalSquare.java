package com.pranay.interview.dp;

import java.util.Arrays;

public class MaximalSquare {
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 0, 1, 0, 0},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 0, 1, 1, 1}
		};
		int size = maximalSquare(matrix);
		System.out.println(size);
	}

	private static int maximalSquare(int[][] matrix) {
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int max = 0;
		for (int i = 1; i<=matrix.length; i++) {
			for (int j = 1; j<=matrix[0].length; j++) {
				if (matrix[i-1][j-1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}

		for (int i=0 ;i<dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return max * max;
	}
}
