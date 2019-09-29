package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences {
	public static void main(String[] args) {
		int[] arr = {1,2};
		System.out.println(uniqueOccurrences(arr));
	}

	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> hm = new HashMap<>();
		Map<Integer, Integer> unique = new HashMap<>();
		for (Integer i: arr) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		hm.forEach((k, v) -> System.out.println(k + " - " +v));

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if(unique.containsKey(entry.getValue())) {
				return false;
			} else {
				unique.put(entry.getValue(), entry.getKey());
			}
		}
		return true;
	}
}
