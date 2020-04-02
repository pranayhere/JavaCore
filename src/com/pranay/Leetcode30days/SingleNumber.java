package com.pranay.Leetcode30days;

public class SingleNumber {
	public static void main(String[] args) {
		int[] arr = {4,1,2,1,2};
		int num = singleNumber(arr);
		System.out.println("Single number is : " + num);
	}

	private static int singleNumber(int[] arr) {
		int num = 0;
		for (int i=0; i<arr.length; i++) {
			num ^= arr[i];
		}
		return num;
	}
}
