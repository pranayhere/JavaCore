package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringWithoutRepeatingChars {
	public static void main(String[] args) {
		String str = "au";
		int len = lengthOfLongestSubstring(str);
		System.out.println("length : " + len);
	}

	private static int lengthOfLongestSubstring(String str) {
		if (str.length() < 2)
			return str.length();
		Map<Character, Integer> map = new HashMap<>();
		int lo = 0;
		int hi = 0;
		int maxLen = 0;
		for (hi = 0; hi < str.length(); hi++) {
			char c = str.charAt(hi);
			if (map.containsKey(c)) {
				maxLen = Math.max(maxLen, hi - lo);
				lo = Math.max(lo, map.get(c) + 1);
			}
			map.put(c, hi);
		}

		return Math.max(hi - lo, maxLen);
	}
}
