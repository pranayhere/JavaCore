package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class LuckyNumber {
	public static void main(String[] args) {
		int[] arr = {3,19,18,2,9,4,7,11,15,7,14,10,11,9,8,5,4,14,11,4,16,3,13,14,14,15,8,19,3,5,20,15,14,10,16,11,17,20,11,20,15,3,20,5,12,2,15,12,14,16,20,17,15,8,18,9,8,5,12,3,5,15,14,10,2,20,20,3,13,9,1,3,16,18,14,16,13,9,18,13,9,3,5,19};
		int luckyNumber = findLucky(arr);
		System.out.println(luckyNumber);
	}

	private static int findLucky(int[] arr) {
		int luckyNumber = -1;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i=0; i<arr.length; i++) {
			int freq = hm.getOrDefault(arr[i], 0) + 1;
			hm.put(arr[i], freq);
		}

		for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();

			if (key == val && key > luckyNumber) {
				luckyNumber = key;
			}
		}

		return luckyNumber;
	}
}
