package com.pranay.interview.dp;

import java.util.LinkedList;

public class SubarraySumDivisibleByK {
	static int max, divisor;

	public static void main(String[] args) {
		int nums[] = {3, 6, 5, 1, 8};
		int sum = subarraySumDivisibleByK(nums);
		System.out.println(sum);
	}

	private static int subarraySumDivisibleByK(int[] A) {
		int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
		for (int a : A) {
			int[] dp2 = new int[3];
			for (int i = 0; i < 3; ++i)
				dp2[(i + a) % 3] = Math.max(dp[(i + a) % 3], dp[i] + a);
			dp = dp2;
		}
		return dp[0];
	}
}
