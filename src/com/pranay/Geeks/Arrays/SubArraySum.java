package com.pranay.Geeks.Arrays;

public class SubArraySum {

	public static void main(String[] args) {
		int arr[] = {1, 4, 20, 3, 10, 5};
		int sum = 33;
		
		subArraySum(arr, sum);
	}

	private static void subArraySum(int[] arr, int sum) {
		int current_sum = arr[0];
		int start = 0;

		for (int i = 1; i < arr.length; i++) {
			current_sum += arr[i];			
			while (current_sum > sum) {
				current_sum = current_sum - arr[start];
				start++;
			}

			if (current_sum == sum) {
				System.out.println("subarray found at : " + start + " " + i);
				break;
			}
		}
//		System.out.println("No subarray found");
	}

}
