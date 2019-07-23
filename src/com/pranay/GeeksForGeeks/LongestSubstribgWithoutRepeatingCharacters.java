package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstribgWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "bbbbb";
		int len = lengthOfLongestSubstring(s);
		System.out.println(len);
	}

	private static int lengthOfLongestSubstring(String s) {
		int left = 0;
		int right = 0;
		int maxLength = 0;
		Map<Character, Integer> hm = new HashMap<>();
		
		for (right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if (hm.containsKey(ch)) {
				maxLength = Math.max(maxLength, right - left);
				left = Math.max(left, hm.get(ch) + 1);
			}
			hm.put(ch, right);
		}
		return maxLength;
	}
}
