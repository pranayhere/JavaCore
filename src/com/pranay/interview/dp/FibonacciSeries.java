package com.pranay.interview.dp;

import java.util.Arrays;

public class FibonacciSeries {
	public static void main(String[] args) {
		int n = 5;
		int[] fibonacci = printFibonacci(n);
		System.out.println(Arrays.toString(fibonacci));
	}

	private static int[] printFibonacci(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp;
	}
}
