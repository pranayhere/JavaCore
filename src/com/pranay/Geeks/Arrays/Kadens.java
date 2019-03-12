package com.pranay.Geeks.Arrays;

public class Kadens {
	public static void main(String[] args) {
		int[] a = {-2, -3, -4, -1, -2, -1, -5, -3};
		int maxSubArraySum = maxSubArraySum(a);
		System.out.println("maximum subarray sum : " + maxSubArraySum);
	}

	private static int maxSubArraySum(int[] a) {
//		int maxSoFar = 0;
//		int maxEndingHere = 0;
//
//		for (int i : a) {
//			maxEndingHere = maxEndingHere + i;
//			if (maxEndingHere < 0)
//				maxEndingHere = 0;
//			else if (maxSoFar < maxEndingHere)
//				maxSoFar = maxEndingHere;
//		}
//		
//		return maxSoFar;
		
		int max_so_far = a[0];
		int current_max = a[0];
		
		for (int i = 1; i<  a.length; i++) {
			current_max = Math.max(a[i], current_max+a[i]);
			max_so_far = Math.max(max_so_far, current_max);
		}
		return max_so_far;
	}
}
