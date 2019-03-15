package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hackerrank practice questions : dictionaries and hash : counting triplets

public class CountTriplets {
	public static void main(String[] args) {
		List<Long> arr = new ArrayList<>();
		arr.add((long) 1);
		arr.add((long) 3);
		arr.add((long) 9);
		arr.add((long) 9);
		arr.add((long) 27);
		arr.add((long) 81);

		long r = 3;
		long ans = countTriplets(arr, r);
		System.out.println(ans);
	}

	private static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> t2 = new HashMap<>();
		Map<Long, Long> t3 = new HashMap<>();
		long result = 0L;

		Long count = 0L;
		for (Long a : arr) {
			result += t3.getOrDefault(a, 0L);

			if (t2.containsKey(a)) {
				t3.put(a*r, t3.getOrDefault(a*r, 0L) + t2.get(a));
			}

			t2.put(a*r, t2.getOrDefault(a*r, 0L) + 1);
		}

		return result;
	}
}