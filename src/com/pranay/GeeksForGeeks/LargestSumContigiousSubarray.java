package com.pranay.GeeksForGeeks;

public class LargestSumContigiousSubarray {
	public static void main(String[] args) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int max_sum = largestSum(arr);
		System.out.println("Maximum contiguous sum is : "+max_sum);
	}

	private static int largestSum(int[] arr) {
		int max_so_far = arr[0];
		int current_max = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			 current_max = Math.max(arr[i], current_max+arr[i]);
		     max_so_far = Math.max(max_so_far, current_max);
		}
		return max_so_far;
	}
}
