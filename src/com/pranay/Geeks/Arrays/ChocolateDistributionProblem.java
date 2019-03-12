package com.pranay.Geeks.Arrays;

import java.util.Arrays;

public class ChocolateDistributionProblem {

	public static void main(String[] args) {
		int arr[] = {12, 4, 7, 9, 2, 23, 
                25, 41, 30, 40, 28, 
                42, 30, 44, 48, 43, 
                50}; 
		int m = 7;
		int n = arr.length;
		int minDiff = getMinDiff(arr, m, n);
		System.out.println("minimum diff is : " + minDiff);
	}

	private static int getMinDiff(int[] arr, int m, int n) {
		System.out.println("inside min diff");
		if (m == 0 || n == 0)
			return 0;
		
		if (m > n)
			return -1;
		
		Arrays.sort(arr);
		
		int min_diff = Integer.MAX_VALUE; 
		int first = 0, last = 0;
		for (int i = 0; i + m - 1 < n; i++) {
			int diff = arr[i+m-1] - arr[i];
			if (diff < min_diff) {
				min_diff = diff;
				first = i;
				last = i+m-1;
			}
		}
		return (arr[last] - arr[first]);
	}
}
