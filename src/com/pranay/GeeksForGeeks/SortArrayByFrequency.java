package com.pranay.GeeksForGeeks;

import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortArrayByFrequency {
	public static void main(String[] args) {
		int[] arr = {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};
		int[] sorted = sortByFreq(arr);
	}

	private static int[] sortByFreq(int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		
		map.forEach((k, v) -> {
			System.out.println("k : " +k+ " v: " +v);
		});
		
		Map<Integer, Integer> sorted = (Map<Integer, Integer>) map.entrySet()
		        .stream()
		        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
		                LinkedHashMap::new));
		
		System.out.println("-----------------------");
		sorted.forEach((k, v) -> {
			System.out.println("k : " +k+ " v: " +v);
		});
		
		System.out.println("Sorted Based on keys : " + sorted);
		List<Integer> finalAns = sorted.keySet().stream().collect(Collectors.toList()); 
		System.out.println(finalAns);
		
		sorted.forEach((k,v) -> {
			for(int i=0; i<v; i++)
				System.out.print(k + " ");
		});
		
		return null;
	}
}
