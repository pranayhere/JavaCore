package com.pranay.GeeksForGeeks;

public class KConcatenationMaxSum {
	public static void main(String[] args) {
		int[] arr = {1,-2,1};
		int k = 5;

		int maxSum = kConcatenationMaxSum(arr, k);
		System.out.println(maxSum);
	}

	private static int kConcatenationMaxSum(int[] arr, int k) {
		int currentMax = 0;
		int max = 0;

		int n = arr.length;
		for (int i = 0; i < n * Math.min(2, k); i++) {
			currentMax += arr[i % n];

			if (max < currentMax) {
				max = currentMax;
			}

			if (currentMax < 0)
				currentMax = 0;
		}
		return max;
	}
}
