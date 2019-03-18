package com.pranay.GeeksForGeeks;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {3, 2, 1};
		countSwaps(arr);
	}

	private static void countSwaps(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					count++;
				}
			}
		}
		System.out.println("Array is sorted in " + count +" swaps.");
		System.out.println("First Element: " + arr[0]);
		System.out.println("First Element: " + arr[arr.length - 1]);
	}
}
