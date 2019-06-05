package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class pairDiffEqualToK {

	public static void main(String[] args) {
		int k = 2;
		int arr[] = {1, 5, 3, 4, 2};
		int count = pairs(arr, k);
		int count2 = pairs2(arr, k);
		System.out.println(count);
		System.out.println(count2);
	}

	private static int pairs2(int[] arr, int k) {
		Set<Integer> hs = new HashSet<>();
		for (int num: arr) {
			hs.add(num);
		}
//		int count = 0;
//		for (int num: arr) {
//			if (hs.contains(num-k)) {
//				count++;
//			}
//		}
		
		int count = (int) hs.stream()
	            .filter(i -> hs.contains(i - k))
	            .count();
		return count;
	}

	private static int pairs(int[] arr, int k) {
		Arrays.sort(arr);
		int i = 1;
		int j = 0;
		int count = 0;
		while (i<arr.length && j<arr.length) {
			if (arr[i] - arr[j] == k) {
				System.out.println(arr[i]+ " : " +arr[j]);
				count++;
				i++;
				j++;
				continue;
				
			}
			if (arr[i] - arr[j] > k) {
				if (j<arr.length && j!=i) j++;
				continue;
			}
			
			if (arr[i] - arr[j] < k) {
				if (i<arr.length) i++;
				continue;
			}	
		}
		
		return count;
	}

}
