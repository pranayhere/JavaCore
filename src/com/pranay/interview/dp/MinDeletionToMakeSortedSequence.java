package com.pranay.interview.dp;

import java.util.Arrays;

public class MinDeletionToMakeSortedSequence {
	public static void main(String[] args) {
		int[] arr = {30, 40, 2, 5, 1, 7, 45, 50, 8};
		int count = minDeletionToMakeSortedSequence(arr);
		System.out.println(count);
	}

	private static int minDeletionToMakeSortedSequence(int[] arr) {
		int[] T = new int[arr.length];
		Arrays.fill(T, 1);

		int max = 0;
		for (int i = 1; i<arr.length; i++) {
			for (int j = 0; j<i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = Math.max(T[i], 1 + T[j]);
					max = Math.max(max, T[i]);
				}
			}
		}
		System.out.println(Arrays.toString(T));
		return arr.length - max;
	}
}
