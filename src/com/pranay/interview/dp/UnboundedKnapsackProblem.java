package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * Unbounded Knapsack (Repetition of items allowed)
 *
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti,
 * we need to calculate minimum amount that could make up this quantity exactly.
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 *
 * Input : W = 8
 *        val[] = {10, 40, 50, 70}
 *        wt[]  = {1, 3, 4, 5}
 * Output : 110
 * We get maximum value with one unit of
 * weight 5 and one unit of weight 3.
 */
public class UnboundedKnapsackProblem {
	public static void main(String[] args) {
		int W = 8;
		int[] val = {10, 40, 50, 70};
		int[] wt = {1, 3, 4, 5};
		int maxProfit = maxProfit(val, wt, W);
		System.out.println(maxProfit);
	}

	private static int maxProfit(int[] val, int[] wt, int W) {
		int[][] T = new int[val.length + 1][W + 1];

		for (int i=1; i<=val.length; i++) {
			for (int j=1; j<=W; j++) {
				if (j < wt[i-1]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = Math.max(T[i-1][j], val[i-1] + T[i][j-wt[i-1]]);
				}
			}
		}

		print2d(T);
		return T[val.length][W];
	}

	private static void print2d(int[][] arr) {
		for (int[] ints: arr){
			System.out.println(Arrays.toString(ints));
		}
	}
}
