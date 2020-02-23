package com.pranay.GeeksForGeeks;

/**
 * Input: arr = [0,1,2,3,4,5,6,7,8]
 * Output: [0,1,2,4,8,3,5,6,7]
 * Explantion: [0] is the only integer with 0 bits.
 * [1,2,4,8] all have 1 bit.
 * [3,5,6] have 2 bits.
 * [7] has 3 bits.
 * The sorted array by bits is [0,1,2,4,8,3,5,6,7]
 */

import java.util.Arrays;
import java.util.Comparator;

public class SortByBits {
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8};
		int[] ans = sortByBits(arr);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] sortByBits(int[] arr) {
		Integer[] a = new Integer[arr.length];
		for (int i=0; i<a.length; i++)
			a[i] = arr[i];
		Arrays.sort(a, Comparator.comparing(i -> Integer.bitCount(i) * 10000 + i));
		for (int i = 0; i < a.length; ++i)
			arr[i] = a[i];
		return arr;
	}
}
