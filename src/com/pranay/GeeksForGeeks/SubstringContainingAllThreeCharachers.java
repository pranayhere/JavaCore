package com.pranay.GeeksForGeeks;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 1358. Number of Substrings Containing All Three Characters
 */
public class SubstringContainingAllThreeCharachers {
	public static void main(String[] args) {
		String s = "abcabc";
		int count = numberOfSubstrings(s);
		System.out.println(count);
	}

	private static int numberOfSubstrings(String s) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, i);
			if(map.size() == 3) {
				int minIndex = Math.min(map.get('a'), map.get('b'));
				minIndex = Math.min(minIndex, map.get('c'));
				count += minIndex + 1;
			}
		}
		return count;
	}
}
