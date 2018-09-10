package com.pranay.Geeks.dp;
//refer https://www.geeksforgeeks.org/?p=12832
//https://www.youtube.com/watch?v=Ns4LCeeOFS4
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		int n = arr.length;
		int lis = lis(arr, n);
		System.out.println("Longest increasing subsequence is : " + lis);
	}

	private static int lis(int[] arr, int n) {
		int[] lis = new int[n];
		int i,j,max = 0;
		
		/* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ ) 
           lis[i] = 1; 
		
        for (i = 1; i<n; i++) {
        	for (j = 0; j<i; j++) {
        		if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
        			lis[i] = lis[j] + 1;
        	}
        }
        
        for (i=0; i<n; i++) {
        	if (max < lis[i]) {
        		max = lis[i];
        	}
        }
        
        return max;
	}	
}
