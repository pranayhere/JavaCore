package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RockLeeNaruto {

	public static void main(String[] args) {
		int n = 10;
		int m = 4;
		int[] spots = {1, 5, 10, 5};
		int mostVisited = mostVisitedSpot(n, m, spots);
		System.out.println(mostVisited);
	}

	static Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();
	
	private static int mostVisitedSpot(int n, int m, int[] spots) {
		for (int i=0; i<m; i++) {
			if (i == 0) {
				addToMap(spots[i]);
				continue;
			}
			
			addToMap(spots[i-1]);
			addToMap(spots[i]);
		}
		
		tm.forEach((k, v) -> System.out.println("k = " +k+ " v = " +v)); // Print TreeMap
		
		int max=tm.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey(); // Get key with maximum value from treemap

		return max;
	}

	private static void addToMap(int key) {
		int count = 1;
		if (tm.containsKey(key)) {
			count = tm.get(key);
			tm.put(key, count++);
		}
		tm.put(key, count);
	}
}
