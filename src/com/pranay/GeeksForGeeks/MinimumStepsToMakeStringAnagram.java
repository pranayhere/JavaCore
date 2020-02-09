package com.pranay.GeeksForGeeks;
// 1347. Minimum Number of Steps to Make Two Strings Anagram
public class MinimumStepsToMakeStringAnagram {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "mangaar";
		int steps = minSteps(s, t);
		System.out.println(steps);
	}

	private static int minSteps(String sStr, String tStr) {
		int[] s = new int[26];
		int[] t = new int[26];

		int count = 0;

		for (int i=0; i<sStr.length(); i++) {
				s[sStr.charAt(i) - 'a']++;
				t[tStr.charAt(i) - 'a']++;
		}

		for (int i=0; i<s.length; i++) {
			if (t[i] > s[i]) {
				count += Math.abs(t[i] - s[i]);
			}
		}

		return count;
	}
}