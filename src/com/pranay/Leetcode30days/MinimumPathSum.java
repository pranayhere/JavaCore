package com.pranay.Leetcode30days;

import java.util.Arrays;

public class MinimumPathSum {
	public static void main(String[] args) {
		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};

		int sum = minPathSum(grid);
		System.out.println("Min sum : " +sum);
	}

	private static int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int i = 1; i<dp[0].length;i++) {
			dp[0][i] = grid[0][i] + dp[0][i-1];
		}

		for (int i = 1; i<dp.length; i++) {
			dp[i][0] = grid[i][0] + dp[i-1][0];
		}

		for (int i = 1; i<grid.length; i++) {
			for (int j = 1; j<grid[0].length; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}

		return dp[dp.length-1][dp[0].length-1];
	}
}
