package com.pranay.GeeksForGeeks;

public class MaximumSubarraySumOfSizeK {

	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20}; 
		int k = 4;
		maxSum(arr, k);
	}

	private static void maxSum(int[] arr, int k) {
		int n = arr.length;
		int maxSum = 0;
		int currSum = 0;
		if (n < k) {
			System.out.println("Invalid");
			return;
		}
		
		for (int i=0; i<k; i++) {
			maxSum += arr[i];
		}
		currSum = maxSum;
		for (int i = k; i<n; i++) {
			currSum += arr[i] -arr[i-k];
			maxSum = Math.max(currSum, maxSum);
		}
		System.out.println("Max Sum is : "+maxSum);
	}
}