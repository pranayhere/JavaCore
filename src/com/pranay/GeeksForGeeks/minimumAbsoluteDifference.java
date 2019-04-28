package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class minimumAbsoluteDifference {
	public static void main(String[] args) {
		int arr[] = {3, -7, 0};
		int minDiff = minimumAbsoluteDifference(arr);
		System.out.println(minDiff);
	}

	private static int minimumAbsoluteDifference(int[] arr) {
//		int min = Integer.MAX_VALUE;
//		for (int i=0; i<arr.length-1; i++) {
//			for (int j=i+1; j<arr.length; j++) {
//				int diff = Math.abs(arr[i] - arr[j]);
//				if (diff < min)
//					min = diff;
//			}
//		}
//		return min;
		
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<arr.length-1; i++) {
			int diff = Math.abs(arr[i+1] - arr[i]);
			if (diff < min)
				min = diff;
			if (min == 0)
				return 0;
		}
		return min;
	}
}
