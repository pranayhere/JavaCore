package com.pranay.GeeksForGeeks;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.geeksforgeeks.org/arrange-given-numbers-form-biggest-number-set-2/

public class ArraysBiggestNumber {
	
	
	public static void main(String[] args) {
		Integer arr[] = { 1, 34, 3, 98, 9, 76, 45, 4, 12, 121 };
		List<Integer> list = Arrays.asList(arr);

		System.out.println(largestNumber(list));
	}

	private static String largestNumber(List<Integer> list) {
		int n = Collections.max(list).toString().length();
		Map<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();

//		for (Integer num : list) {
//			hm.put(num, getExtendedNum(num, n));
//		}

		Map<Integer, Integer> sorted = (Map<Integer, Integer>) hm.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		List<Integer> finalAns = sorted.keySet().stream().collect(Collectors.toList());

		String str = "";
		for (Integer num : finalAns) {
			str += Integer.toString(num);
		}

		return str;
	}

	private static Integer getExtendedNum(Integer num, int n) {
		String s = Integer.toString(num);
		StringBuilder sb = new StringBuilder(s);
		StringBuilder ans = new StringBuilder();
		while (ans.length() <= n + 1)
			ans.append(sb);

		s = ans.toString().substring(0, n + 1);
		return Integer.parseInt(s);
	}
}
