package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class BirthdayCakeCandles {

	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 3};
		int count = birthdayCakeCandles(arr);
		System.out.println(count);
	}

	private static int birthdayCakeCandles(int[] arr) {
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i : arr) {
			max = Math.max(i, max);
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		return hm.get(max);
	}

}
