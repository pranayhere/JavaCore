package com.pranay.interview.dp;

import java.util.Arrays;

public class CuttingRodToMaximizeProfit {
	public static void main(String[] args) {
		int L = 5; // max length
		int[] len = {1, 2, 3, 4};
		int[] profit = {2, 5, 7, 8};

		int maxProfit = maxProfit(len, profit, L);
		System.out.println(maxProfit);
	}

	private static int maxProfit(int[] len, int[] profit, int L) {
		int[][] T = new int[profit.length + 1][L + 1];

		for (int i = 1; i<=profit.length; i++) {
			for (int j=1; j<=L; j++) {
				if (j < len[i-1]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = Math.max(T[i-1][j], profit[i-1] + T[i][j - len[i-1]]);
				}
			}
		}

		print2d(T);
		return T[profit.length][L];
	}

	private static void print2d(int[][] arr) {
		for (int[] nums: arr) {
			System.out.println(Arrays.toString(nums));
		}
	}
}
