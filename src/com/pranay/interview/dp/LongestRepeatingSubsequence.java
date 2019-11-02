package com.pranay.interview.dp;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String str = "AABEBCDD";
		int len = longestRepeatingSubsequence(str);
		System.out.println(len);
	}

	private static int longestRepeatingSubsequence(String str) {
		String[] arr = str.split("");
		int[] T = new int[arr.length];

		for (int i=1; i<arr.length; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j].equals(arr[i])) {
					T[i] = Math.max(T[i], 1 + T[j]);
				}
			}
			if (T[i] < T[i-1]) {
				T[i] = T[i-1];
			}
		}
		System.out.println(Arrays.toString(T));
		return T[arr.length - 1];
	}
}
