package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;
		int len = lengthOfLongestSubstringKDistinct(s, k);
		System.out.println("length : " + len);
	}

	private static int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int lo = 0;
		int hi = 0;
		int maxLen = 0;

		for (hi = 0; hi < s.length(); hi++) {
			char c = s.charAt(hi);
			map.put(c, map.getOrDefault(c, 0) + 1);

			while (map.size() > k) {
				if (lo <= hi && map.get(s.charAt(lo)) > 0) {
					map.put(s.charAt(lo), map.get(s.charAt(lo)) - 1);
				}

				if (map.get(s.charAt(lo)) == 0) {
					map.remove(s.charAt(lo));
				}

				lo++;
			}

			maxLen = Math.max(maxLen, hi - lo + 1);
		}

		return maxLen;
	}
}
