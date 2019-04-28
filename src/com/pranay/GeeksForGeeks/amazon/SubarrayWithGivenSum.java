package com.pranay.GeeksForGeeks.amazon;

public class SubarrayWithGivenSum {
	public static void main(String[] args) {
		int arr[] = {1,2,3,7,5};
		int k = 12;
		
		subarrayWithSum(arr, k);
	}

	private static void subarrayWithSum(int[] arr, int k) {
		int start = 0, end = 0;
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			if (sum == k) {
				break;
			}
			sum += arr[i];
			if (sum < k) {
				end++;
			} else if (sum > k) {
				sum -= arr[start];
				start++;
			}
			System.out.println("i : " + i +" current Sum : " + sum + " StartIdx : " +start+ " endIdx : " + end);
		}
		System.out.println("Start : " +start+ " End : " +end);
	}
}
