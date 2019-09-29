package com.pranay.GeeksForGeeks;

// 1208. Get Equal Substrings Within Budget
// https://leetcode.com/problems/get-equal-substrings-within-budget/
// Sliding Window

public class EqualSubstring {
	public static void main(String[] args) {
		String s = "abcd", t = "bcdf";
		int cost = 3;
		System.out.println(equalSubstring(s, t, cost));
	}

	public static int equalSubstring(String s, String t, int k) {
		int n = s.length();
		int i = 0, j;
		for (j = 0; j < n; j++) {
			k -= Math.abs(s.charAt(j) - t.charAt(j));
			if (k < 0) {
				k += Math.abs(s.charAt(i) - t.charAt(i));
				++i;
			}
		}
		return j - i;
	}
}
