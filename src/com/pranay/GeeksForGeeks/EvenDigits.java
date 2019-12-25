package com.pranay.GeeksForGeeks;

public class EvenDigits {
	public static void main(String[] args) {
		int[] nums = {12,345,2,6,7896};
		int count = findNumbers(nums);
		System.out.println(count);
	}

	private static int findNumbers(int[] nums) {
		int count = 0;
		for (int num: nums) {
			String n = String.valueOf(num);
			if (n.length() % 2 == 0) {
				count++;
			}
		}
		return count;
	}
}
