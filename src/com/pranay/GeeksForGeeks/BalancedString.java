package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class BalancedString {
	public static void main(String[] args) {
		String s = "WWEQERQWQWWRWWERQWEQ";
		int count = balancedString(s);
		System.out.println(count);
	}

	private static int balancedString(String str) {
		int len = str.length() / 4;
		System.out.println(len);
		int count = 0;
		Map<String, Integer> hm = new HashMap<>();
		for (String s: str.split("")) {
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}

		hm.forEach((k, v) -> System.out.println(k + " - "+ v));

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			if (entry.getValue() != len) {
				count += Math.abs(entry.getValue() - len);
			}
		}
		return count;
	}
}
