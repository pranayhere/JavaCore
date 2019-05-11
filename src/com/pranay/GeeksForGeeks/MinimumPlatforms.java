package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class MinimumPlatforms {
	public static void main(String[] args) {
		int[] arr = {900, 940, 950, 1100, 1500, 1800};
		int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
		
		int platforms = minPlatforms(arr, dep);
		System.out.println("Min platform required is : " + platforms);
	}

	private static int minPlatforms(int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int platform = 0;
		int minPlatform = 0;
		int i = 0;
		int j = 0;

		while (i < arr.length && j < dep.length) {
			System.out.println("Comparing i: " + i + " j: " + j + " arr: " + arr[i] + " dep: " + dep[j] + " current :  " + platform + " " + " Min Platforms : " + minPlatform);
			if (arr[i] < dep[j]) {
				platform++;
				if (i < arr.length)
					i++;
			}
			else if (arr[i] > dep[j]) {
				platform--;
				if (j < dep.length)
					j++;
			}

			if (platform > minPlatform) {
				minPlatform = platform;
			}
		}
		return minPlatform;
	}
}
