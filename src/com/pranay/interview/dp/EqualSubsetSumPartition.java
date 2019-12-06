package com.pranay.interview.dp;

import java.util.Arrays;

public class EqualSubsetSumPartition {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		System.out.println(subsetSum(arr));
	}

	private static boolean subsetSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0) { // if sum is odd, array can not be divided into two equal sum partitions
			return false;
		}

		int total = sum / 2;
		boolean[][] T = new boolean[arr.length + 1][total + 1];

		for (int i = 0; i <= arr.length; i++) {
			T[i][0] = true;
		}

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j < arr[i - 1]) {
					T[i][j] = T[i - 1][j];
				} else {
					T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
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