package com.pranay.GeeksForGeeks;

public class MinimumSwaps2 {
	public static void main(String[] args) {
		int[] arr = {7, 1, 3, 2, 4, 5, 6};
		int minSwaps = minimumSwaps(arr);
		System.out.println(minSwaps);
	}

	
	private static int minimumSwaps(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i+1) {
				continue;
			}
			swap(i, arr[i]-1, arr);
			
			i = 0;
			count ++;
			
			if (i == arr.length-1)
				break;
		}
		return count;
	}

	private static void swap(int idx_i, int idx_j, int[] arr) {
		int temp = arr[idx_i];
		arr[idx_i] = arr[idx_j];
		arr[idx_j] = temp;
	}
}
