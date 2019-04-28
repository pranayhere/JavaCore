package com.pranay.GeeksForGeeks;

import java.util.stream.Stream;

public class minSwapsConsecativeNumbers {
	public static void main(String[] args) {
//		String str = "128567349";
		String str = "152243"; //expected " 54123
		int k = 4;
		minSwaps(str, k);
	}

	private static void minSwaps(String str, int k) {
		final int[] arr = Stream.of(str.split(""))
				.mapToInt(Integer::parseInt)
				.toArray();

		int ans[] = new int[arr.length];
		for (int i = 0; i < arr.length && k > 0; i++) {
			for (int l : arr) {
				System.out.print(l + " ");
			}
			System.out.println();
			System.out.println("i : "+i);
			int currentMax = 0;
			int idx = i;
			System.out.println("K : " +k);
			
			for (int j = i; j < i+k+1; j++) {
				if (j > arr.length-1) {
					break;
				}
				if (currentMax < arr[j]) {
					currentMax = arr[j];
					idx = j;
				}
			}
			System.out.println();
			
			System.out.println("currentMax = " + currentMax);
			System.out.println("idx = " + idx);
			System.out.print("l : ");
			for (int l = idx; l>i; l--) {
				System.out.print(l + " ");
				int temp = arr[l];
				arr[l] = arr[l-1];
				arr[l-1] = temp;
				k--;
			}
			System.out.println();
		}
		System.out.println("Final answer : ");
		for (int l : arr) {
			System.out.print(" " + l);
		}
	}
}
