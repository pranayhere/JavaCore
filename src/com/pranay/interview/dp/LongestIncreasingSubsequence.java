package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * The Longest Increasing Subsequence (LIS) problem is to
 * find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 *
 * Ex : 3 4 -1 0 6 2 3
 * op : 4
 * Exp : -1 0 2 3 is the longest increasing subsequence
 */

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = {3, 4, -1, 0, 6, 2, 3};
		int len = longestIncreasingSubsequence(arr);
		System.out.println(len);
	}

	private static int longestIncreasingSubsequence(int[] arr) {
		int[] T = new int[arr.length];
		Arrays.fill(T, 1);
		for (int i = 1; i<arr.length; i++) {
			for (int j = 0; j<i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = Math.max(T[i], 1 + T[j]);
				}
			}
		}
		return T[T.length-1];
	}
}
