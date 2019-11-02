package com.pranay.interview.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A subsequence of arr[] is called Bitonic if it is first increasing, then decreasing.
 *
 * Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
 * Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
 */
public class LongestBitonicSubsequence {
	public static void main(String[] args) {
		Integer[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
		int len = longestBitonicSubsequence(arr);
		System.out.println(len);
	}

	private static int longestBitonicSubsequence(Integer[] arr) {
		int[] len1 = longestIncreasingSubsequence(arr);
		Collections.reverse(Arrays.asList(arr));
		int[] len2 = longestIncreasingSubsequence(arr);

		int max = 0;
		for (int i=0; i<len1.length; i++) {
			max = Math.max(max, (len1[i] + len2[i]) - 1);
		}
		return max;
	}

	private static int[] longestIncreasingSubsequence(Integer[] arr) {
		int[] T = new int[arr.length];
		Arrays.fill(T, 1);
		for (int i=1; i<arr.length; i++) {
			for (int j = 0; j<i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = Math.max(T[i], 1 + T[j]);
				}
			}
		}
		System.out.println(Arrays.toString(T));
		return T;
	}
}
