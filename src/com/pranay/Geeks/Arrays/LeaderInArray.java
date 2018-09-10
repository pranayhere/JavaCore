package com.pranay.Geeks.Arrays;

public class LeaderInArray {

	public static void main(String[] args) {
		int[] arr = {16, 17, 4, 3, 5, 2};
		arrayLeader(arr, arr.length);
	}

	private static void arrayLeader(int[] arr, int len) {
		int max_from_right = arr[len - 1];
		System.out.print(max_from_right + " ");
		for (int i = len-2; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				max_from_right = arr[i];
				System.out.print(max_from_right + " ");
			}
		}
	}

}
