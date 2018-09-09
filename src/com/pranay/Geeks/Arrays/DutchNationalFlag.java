package com.pranay.Geeks.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {
		int arr[] = {0,1,2,0,1,2};
		sort012(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void sort012(int[] arr) {
		int hi = arr.length - 1;
		int low = 0;
		int mid = 0;
		int temp = 0;
		
		while (mid <= hi) {
			switch (arr[mid]) {
				case 0:
					temp = arr[low];
					arr[low] = arr[mid];
					arr[mid] = temp;
					mid++;
					low++;
					break;
				case 1:
					mid ++;
					break;
				case 2:
					temp = arr[mid];
					arr[mid] = arr[hi];
					arr[hi] = temp;
					hi--;
					break;
			}
		}
	}
}
