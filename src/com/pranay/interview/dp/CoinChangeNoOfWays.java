package com.pranay.interview.dp;

import java.util.Arrays;

public class CoinChangeNoOfWays {
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int total = 5;
		int ways = numberOfWays(coins, total);
		System.out.println(ways);
	}

	private static int numberOfWays(int[] coins, int total) {
		int[][] T = new int[coins.length][total + 1];
		for (int i=0; i<coins.length; i++) {
			T[i][0] = 1;
		}

		for (int j=0; j<=total; j++) {
			T[0][j] = 1;
		}

		for (int i = 1; i<coins.length; i++) {
			for (int j = 1; j<=total; j++) {
				if (j < coins[i]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = T[i-1][j] + T[i][j - coins[i]];
				}
			}
		}

		print2d(T);
		return T[coins.length - 1][total];
	}

	private static void print2d(int[][] arr) {
		for (int[] ints : arr) {
			System.out.println(Arrays.toString(ints));
		}
	}
}
