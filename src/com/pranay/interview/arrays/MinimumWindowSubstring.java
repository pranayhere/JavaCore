package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		String str = minWindow(S, T);
		System.out.println(str);
	}

	private static String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : t.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int required = map.size();
		int l = 0, r = 0;
		int formed = 0;
		Map<Character, Integer> windowCount = new HashMap<>();

		int[] ans = {-1, 0, 0};

		while (r < s.length()) {
			char ch = s.charAt(r);
			windowCount.put(ch, windowCount.getOrDefault(ch, 0) + 1);
			if (map.containsKey(ch) && map.get(ch).intValue() == windowCount.get(ch).intValue()) {
				formed++;
			}

			while (l <= r && formed == required) {
				ch = s.charAt(l);
				if (ans[0] == -1 || r - l + 1 < ans[0]) {
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}

				windowCount.put(ch, windowCount.get(ch) - 1);
				if (map.containsKey(ch) && windowCount.get(ch) < map.get(ch)) {
					formed--;
				}

				l++;
			}
			r++;
		}
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
}
