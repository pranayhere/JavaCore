package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class matchingStrings {
	public static void main(String[] args) {
		String[] strings = {"aba", "baba", "aba", "xzxb"};
		String[] queries = {"aba", "xzxb", "ab"};
		
		int[] matchCount = matchStrings(strings, queries);
		for (int i : matchCount)
			System.out.println(i);
	}

	private static int[] matchStrings(String[] strings, String[] queries) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for(String str : strings) {
			int count = 1;
			if (hm.containsKey(str)) {
				count = hm.get(str);
				hm.put(str, count++);
			}
			hm.put(str, count);
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (String query : queries) {
			if (!hm.containsKey(query)) {
				list.add(0);
				continue;
			}
			list.add(hm.get(query));
		}
		
		return list.stream().mapToInt(i -> i).toArray();
	}
}
