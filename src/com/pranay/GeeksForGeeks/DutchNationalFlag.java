package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {
		int[] arr = {0,1,2,0,1,2,0,1,2};
		System.out.println(Arrays.toString(arr));
		int[] sorted = sort012(arr);
		System.out.println(Arrays.toString(sorted));
	}

	private static int[] sort012(int[] arr) {
		int lo = 0;
		int hi = arr.length-1;
		int mid = 0;
		int temp = 0;
		while (mid <= hi) {
			switch (arr[mid]) {
			case 0:
				temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] = temp;
				hi--;
				break;
			}
		}
		return arr;
	}

}
