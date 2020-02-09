package com.pranay.GeeksForGeeks;

public class SubarrayOfSizeK {
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1};
		int k = 1;
		int threshold = 0;

		int count = numOfSubarrays(arr, k, threshold);
		System.out.println(count);
	}

	private static int numOfSubarrays(int[] arr, int k, int threshold) {
		int sum = 0;
		int avg = 0;
		int count = 0;

		for (int i = 0; i < k-1; i++) {
			sum += arr[i];
		}

		for (int i = k-1; i < arr.length; i++) {
			sum += arr[i];
			avg = sum / k;
			if (avg >= threshold) {
				count++;
			}
			sum -= arr[i-k+1];
		}

		return count;
	}
}
