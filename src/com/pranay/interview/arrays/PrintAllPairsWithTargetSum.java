package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintAllPairsWithTargetSum {
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, -2, 6, 8, 9, 11};
		int sum = 6;
		System.out.println("------------ hashing ------------");
		printPairs(arr, sum);
		System.out.println("------------ two pointer ------------");
		printPairTwoPointer(arr, sum);
	}

	private static void printPairs(int[] arr, int sum) {
		Set<Integer> hs = new HashSet<>();
		for (int i = 0; i<arr.length; i++) {
			if (hs.contains(arr[i])) {
				System.out.println(arr[i] +" "+ (sum - arr[i]));
			}
			hs.add(sum - arr[i]);
		}
	}

	private static void printPairTwoPointer(int[] arr, int sum) {
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			if (arr[low] + arr[high] == sum) {
				System.out.println(arr[low] + " " + arr[high]);
			}
			if (arr[low] + arr[high] > sum) {
				high--;
			} else {
				low ++;
			}
		}
	}
}
