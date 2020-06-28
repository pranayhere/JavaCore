package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * Count ways to reach n'th stair if you are allowed to take 1 or 2 steps at a time.
 * https://www.youtube.com/watch?v=CFQk7OQO_xM
 */

public class StaricaseProblem {
	public static void main(String[] args) {
		int n = 5;
		int noOfWays = staircaseProblem(n);
		System.out.println(noOfWays);
	}

	private static int staircaseProblem(int n) {
		int[] dp = new int[n + 2];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

        System.out.println(Arrays.toString(dp));
		return dp[dp.length-1];
	}
}
