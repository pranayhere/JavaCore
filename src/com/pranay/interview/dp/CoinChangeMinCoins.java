package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChangeMinCoins {
	public static void main(String[] args) {
		int[] coins = {1, 5, 6, 8};
		int total = 10;
		System.out.println(minCoins(coins, total));
	}

	private static int minCoins(int[] coins, int total) {
		int[][] T = new int[coins.length + 1][total + 1];

		for(int i=1; i<=total; i++) {
			T[0][i] = total + 1;
		}

		for (int i=1; i<=coins.length; i++) {
			for (int j=1; j<=total; j++) {
				if (j < coins[i-1]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = Math.min(T[i-1][j], T[i][j-coins[i-1]] + 1);
				}
			}
		}

		print2d(T);
		return T[coins.length][total] > total ? -1 : T[coins.length][total];
	}

	private static void print2d(int[][] arr) {
		for (int[] ints : arr) {
			System.out.println(Arrays.toString(ints));
		}
	}
}
