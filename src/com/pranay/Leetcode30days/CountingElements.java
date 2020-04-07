package com.pranay.Leetcode30days;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {
	public static void main(String[] args) {
		int[] arr = {1,1,2,2};
		int count = countElements(arr);
		System.out.println("count : " + count);
	}

	private static int countElements(int[] arr) {
		int count = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int num: arr) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		hm.forEach((k, v) -> System.out.println(k+ " - " +v));

		for (Integer k: hm.keySet()) {
			if (hm.containsKey(k-1)) {
				count += hm.get(k-1);
			}
		}
		return count;
	}
}
