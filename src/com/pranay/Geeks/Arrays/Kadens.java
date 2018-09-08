package com.pranay.Geeks.Arrays;

public class Kadens {
	public static void main(String[] args) {
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		int maxSubArraySum = maxSubArraySum(a);
		System.out.println("maximum subarray sum : " + maxSubArraySum);
	}

	private static int maxSubArraySum(int[] a) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		
		for (int i : a) {
			maxEndingHere = maxEndingHere + i;
			if (maxEndingHere < 0)
				maxEndingHere = 0;
			if (maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}
}
