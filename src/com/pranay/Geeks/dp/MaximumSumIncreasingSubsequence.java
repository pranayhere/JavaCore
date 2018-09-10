package com.pranay.Geeks.dp;


// refer https://www.geeksforgeeks.org/?p=12832
// https://www.youtube.com/watch?v=Ns4LCeeOFS4
public class MaximumSumIncreasingSubsequence {

	
	public static void main(String[] args) {
		int arr[] = {1, 101, 2, 3, 100, 4, 5}; 
        int n = arr.length; 
        System.out.println("Sum of maximum sum increasing subsequence is "+ maxSumIS( arr, n )); 
	}

	private static int maxSumIS(int[] arr, int n) {
		int i = 0;
		int j = 0;
		int max = 0;
		int[] msis = new int[n];
		
		for (i=0; i<n; i++) {
			msis[i] = 1;
		}
		
		for (i=1; i<n; i++) {
			for (j=0; j<i; j++) {
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];
			}
		}
		
		for (i=0; i<n; i++) {
			if (max < msis[i]) 
				max = msis[i];
		}
		
		return max;
	}
}
