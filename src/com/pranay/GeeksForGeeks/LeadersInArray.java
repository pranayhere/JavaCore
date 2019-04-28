package com.pranay.GeeksForGeeks;

public class LeadersInArray {
	public static void main(String[] args) {
		int[] arr = {7, 4, 5, 7, 3};
		leaders(arr);
	}

	private static void leaders(int[] arr) {
		int leader = Integer.MIN_VALUE;
		for (int i=arr.length-1; i>=0; i--) {
			if (arr[i] >= leader) {
				System.out.println(arr[i]);
				leader = arr[i];
			}
		}
	}
}
