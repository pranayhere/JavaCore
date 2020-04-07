package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
	public static void main(String[] args) {
		String s = "annabelle";
		int k = 2;
		boolean ans = canConstruct(s, k);
		System.out.println("Can Construct : " + ans);
	}

	private static boolean canConstruct(String s, int k) {
		Map<String, Integer> map = new HashMap<>();
		String[] strs = s.split("");
		for (String ch: strs) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		map.forEach((key, v) -> System.out.println(key + " -> " +v));
		int even = 0;
		int odd = 0;
		for (Map.Entry<String, Integer> entry: map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			if (val % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}

		if (odd <= k && k <= s.length()) {
			return true;
		}
		return false;
	}
}
