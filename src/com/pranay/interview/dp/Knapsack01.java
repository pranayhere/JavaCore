package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 */
public class Knapsack01 {
	public static void main(String[] args) {
		int total = 7;
		int[] weight = {1, 5, 4, 3};
		int[] value = {1, 7, 5, 4};

		int profit = knapsack(weight, value, total);
		System.out.println("Max profit : " + profit);
	}

	private static int knapsack(int[] wt, int[] val, int W) {
		int[][] T = new int[wt.length + 1][W+1];

		for (int i = 1; i<=wt.length; i++) {
			for (int j = 1; j <= W; j++) {
				if (j < wt[i-1]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = Math.max(val[i-1] + T[i-1][j - wt[i-1]], T[i-1][j]);
				}
			}
		}

		print2d(T);
		return T[wt.length][W];
	}

	private static void print2d(int[][] arr) {
		for (int[] ints : arr) {
			System.out.println(Arrays.toString(ints));
		}
	}
}
