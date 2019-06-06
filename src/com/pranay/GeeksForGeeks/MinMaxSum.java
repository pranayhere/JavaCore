package com.pranay.GeeksForGeeks;
// https://www.hackerrank.com/challenges/mini-max-sum/problem
import java.util.Arrays;
import java.util.OptionalInt;

public class MinMaxSum {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		miniMaxSum(arr);
	}

	private static void miniMaxSum(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		long sum = 0;
		for (int i : arr) {
			min = Math.min(i, min);
			max = Math.max(i, max);
			sum += i;
		}
		System.out.println((sum - max) + " " + (sum - min));
	}
	
}
