package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class MakeArrayIncreasing {
	public static void main(String[] args) {
		int[] arr1 = {1, 5, 3, 6, 7};
		int[] arr2 = {4, 3, 1};
		int ans = makeArrayIncreasing(arr1, arr2);
		System.out.println("ans : " + ans);
	}
	private static int makeArrayIncreasing(int[] arr1, int[] arr2) {
		for (int i = 1; i < arr1.length; i++) {
			if (arr1[i-1] >= arr1[i]) {
				int minarr[] = getMinBtw(arr1[i], arr1[i-2], arr2);
				int rep = minarr[0];
				arr2[minarr[1]] = Integer.MAX_VALUE;
			}
		}
		System.out.println(Arrays.toString(arr1));
		return 0;
	}

	private static int[] getMinBtw(int a, int b, int[] arr) {
		int min = Integer.MAX_VALUE;
		int idx = Integer.MAX_VALUE;
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] >= a && arr[i] <= b) {
				if (arr[i] < min) {
					min = arr[i];
					idx = i;
				}
			}
		}

		return new int[]{min, idx};
	}
}
