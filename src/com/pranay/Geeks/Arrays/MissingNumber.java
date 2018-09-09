package com.pranay.Geeks.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5};
		int num = 5;
		int missingNumber = findMissingNumber(arr, num);
		System.out.println("missing number is : " + missingNumber);
	}

	private static int findMissingNumber(int[] arr, int num) {
		int total = num * (num + 1) / 2;
		for (int i = 0; i < arr.length; i++) {
			total = total - arr[i]; 
		}
		return total;
	}
}
