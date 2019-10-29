package com.pranay.interview.dp;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		int sum = maxSumIncreasingSubsequence(arr);
		System.out.println(sum);
	}

	private static int maxSumIncreasingSubsequence(int[] arr) {
		int[] T = Arrays.copyOf(arr, arr.length);
		int maxSum = 0;
		for (int i = 1; i<arr.length; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = Math.max(T[i], T[j] + arr[i]);
					maxSum = Math.max(maxSum, T[i]);
				}
			}
		}
		System.out.println(Arrays.toString(T));
		return maxSum;
	}
}