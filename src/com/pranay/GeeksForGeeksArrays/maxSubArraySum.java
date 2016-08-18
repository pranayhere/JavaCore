package com.pranay.GeeksForGeeksArrays;

public class maxSubArraySum {
	public static int maxSubArraySumMethod(int[] a, int size) {
		int max_so_far = a[0];
		int curr_max = a[0];
		
		for(int i=0; i<size; i++) {
			curr_max = Math.max(a[i], curr_max+a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		int max_sum = maxSubArraySumMethod(a, a.length);
		System.out.println("max contigious subarray sum is : "+max_sum);
	}
}