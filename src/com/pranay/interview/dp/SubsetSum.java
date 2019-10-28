package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * Given an array of integers and total, is there a subset that
 * add upto the total
 */
public class SubsetSum {
	public static void main(String[] args) {
		int[] arr = {2, 3, 7, 8, 10};
		int total = 11;
		System.out.println(subsetSum(arr, total));
	}

	private static boolean subsetSum(int[] arr, int total) {
		boolean[][] T = new boolean[arr.length + 1][total + 1];

		for (int i = 0; i <=arr.length; i++) {
			T[i][0] = true;
		}

		for (int i = 1; i<=arr.length; i++) {
			for (int j = 1; j<=total; j++) {
				if (j < arr[i-1]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = T[i-1][j] || T[i-1][j - arr[i-1]];
				}
			}
		}
		print2d(T);
		return T[arr.length][total];
	}

	private static void print2d(boolean[][] arr) {
		for (boolean[] ints : arr) {
			System.out.println(Arrays.toString(ints));
		}
	}
}
